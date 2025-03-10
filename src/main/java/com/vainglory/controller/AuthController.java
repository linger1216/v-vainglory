package com.vainglory.controller;

import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vainglory.constant.Constants;
import com.vainglory.domain.Client;
import com.vainglory.domain.R;
import com.vainglory.domain.User;
import com.vainglory.domain.dto.UserReq;
import com.vainglory.enums.E;
import com.vainglory.service.*;
import com.vainglory.utils.JsonUtils;
import com.vainglory.utils.MapstructUtils;
import com.vainglory.utils.SpringUtils;
import com.vainglory.utils.ValidatorUtils;
import com.vainglory.utils.login.JwtUtils;
import com.vainglory.utils.login.LoginHelper;
import io.jsonwebtoken.Claims;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vainglory.domain.dto.LoginReq;
import com.vainglory.domain.dto.LoginResp;

import java.util.Date;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
@Validated
public class AuthController {

  @Autowired
  private JwtUtils jwtUtils;

  private final IClientService clientService;
  private final IRoleService roleService;
  private final IDeptService deptService;
  private final IPostService postService;
  private final IMenuService menuService;
  private final IUserService userService;
  /*
    这里必须要采用字符串来进行参数传递, 而不要用结构化的
    因为这里实际上有多种登录方式, 每种登录方式的参数各有不同,如:A,B,C,D 要不就定义一种结构,包含ABCD4种参数,
    但在参数验证环节,不是特别好验证,Java验证怎么根据类型,来仅仅对其中的一组参数进行验证, 有点麻烦,所以采用了字符串
    既然要是用字符串来进行参数传递, 那么在参数验证环节,那仅仅只有NotBlank了, 具体的参数验证分为2个部分:
    1. 公共字段的验证, 这一块使用ValidatorUtils.validate(req);来手动验证
    2. 私有字段的验证, 只能使用各个登录服务接口,如:PasswordLoginService.login来进行内部验证了
    PS: 另外参考的代码中, 这里是使用GetBean方式来动态获取登录服务, 我没有采用, 我觉得有时候代码需要笨一点, 这样可以让自己看的更清楚.
    再吐槽一点, 太多的注解, 会迷失在注解的海洋中, 各种的依赖注入,会丢失很多细节, 不如按部就班的构造, 足够清晰足够简单.
    这也是我诟病JAVA的地方, 但没办法,这个项目用Java实现是一个学习Java的过程, 如果追求效率, 早就用Golang实现了.
   */
  @PostMapping("/login")
  public R<LoginResp> login(@RequestBody @NotBlank String body) {
    LoginReq req = JsonUtils.parseObject(body, LoginReq.class);
    ValidatorUtils.validate(req);
    if (req == null) {
      return R.F(E.bad_request);
    }

    String clientId = req.getClientId();

    // 查询用户的client和对应tenant是否合法
    Client client = clientService.getById(clientId);
    if (client == null) {
      return R.F(E.no_authorization);
    }

    if (!client.getTenantId().equals(req.getTenantId())) {
      return R.F(E.no_authorization);
    }

    // 检查用户提交的登录请求在不在授权范围中
    String grantTypeReq = req.getGrantType();
    if (!client.getGrantType().contains(grantTypeReq)) {
      return R.F(E.invalid_grant_type);
    }

    // 根据grantTypeReq来拿到正确的验证服务
    String beanName = grantTypeReq + Constants.LOGIN_VALID_SERVICE;
    ILoginValidService loginValidService = SpringUtils.getBean(beanName);
    R<User> resp = loginValidService.login(body, client);
    if (resp.isFailed()) {
      return R.F(resp);
    }

    // 登录通过
    User user = resp.getData();
    if (user == null) {
      return R.F(E.no_user);
    }

    // TODO: sesion
    // 真正登录记录一些实用的东西





    // 生成token
    String token = jwtUtils.genAccessToken(user.getId());
    Claims claims = jwtUtils.validateToken(token);
//    jwtUtils.parsePayload(token);
    Date expiration = claims.getExpiration();
    int expireInSeconds = (int) ((expiration.getTime() - System.currentTimeMillis()) / 1000);
    LoginResp ret = new LoginResp();
    ret.setAccessToken(token);
    ret.setExpireIn(expireInSeconds);
    ret.setUserId(user.getId());
    return R.OK(ret);
  }


  @PostMapping("/register")
  public R<Void> register(@RequestBody UserReq req) {
    User user = MapstructUtils.convert(req, User.class);
    if (user == null) {
      return R.F(E.bad_request);
    }

    // 查询数据库是否有此用户
    {
      QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("username", req.getUsername());
      User dbUser = userService.getOne(wrapper);
      if (dbUser != null) {
        return R.F(E.user_exist);
      }
    }

    // 检查手机号是否存在
    {
      QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("phone", req.getPhone());
      User dbUser = userService.getOne(wrapper);
      if (dbUser != null) {
        return R.F(E.user_exist_phone);
      }
    }

    String salt = BCrypt.gensalt();
    user.setSalt(salt);
    String password = user.getPassword();
    String encryptedPassword = BCrypt.hashpw(password, salt);
    user.setPassword(encryptedPassword);
    boolean result = userService.save(user);
    if (!result) {
      return R.F(E.server_error);
    }
    return R.OK();
  }
}
