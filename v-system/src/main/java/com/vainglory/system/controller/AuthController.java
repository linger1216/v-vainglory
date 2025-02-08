package com.vainglory.system.controller;


import com.vainglory.common.core.domain.R;
import com.vainglory.common.core.utils.JsonUtils;
import com.vainglory.common.core.utils.ValidatorUtils;
import com.vainglory.system.domain.Client;
import com.vainglory.system.domain.User;
import com.vainglory.system.domain.dto.LoginReq;
import com.vainglory.system.domain.dto.LoginResp;
import com.vainglory.system.enums.E;
import com.vainglory.system.service.IClientService;
import com.vainglory.system.service.ILoginService;
import com.vainglory.system.service.impl.*;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
  private final IClientService clientService;

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
    String tenantId = req.getTenantId();

    // 查询用户的client和对应tenant是否合法
    Client client = clientService.getById(clientId);
    if (client == null || !client.getTenantId().equals(tenantId)) {
      return R.F(E.no_authorization);
    }

    // 检查用户提交的登录请求在不在授权范围中
    String grantTypeReq = req.getGrantType();
    if (!client.getGrantType().contains(grantTypeReq)) {
      return R.F(E.invalid_grant_type);
    }

    // 根据grantTypeReq来验证code是否正确
    // 如果正确返回拿到的user对象
    ILoginService loginService = switch (grantTypeReq) {
      case "password" -> new PasswordLoginService();
//      case "sms" -> new PasswordLoginService();
//      case "social" -> new PasswordLoginService();
//      case "xcx" -> new PasswordLoginService();
//      case "email" -> new PasswordLoginService();
      default -> throw new IllegalStateException("Unexpected value: " + grantTypeReq);
    };

    R<User> resp = loginService.login(body, client);
    if (resp.isFailed()) {
      return R.F(resp);
    }



    {

//      StpUtil.login(user.getId());
//      String tokenValue = StpUtil.getTokenInfo().getTokenValue();
//      LoginResp loginResp = new LoginResp();
//      loginResp.setToken(tokenValue);
//      return loginResp;
    }

    //    StpUtil.login(10001);
//    String tokenValue = StpUtil.getTokenInfo().getTokenValue();

    return null;
  }
}
