package com.vainglory.service.impl;

import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vainglory.domain.Client;
import com.vainglory.domain.R;
import com.vainglory.domain.User;
import com.vainglory.domain.dto.PasswordLoginReq;
import com.vainglory.enums.E;
import com.vainglory.service.ILoginValidService;
import com.vainglory.service.IUserService;
import com.vainglory.utils.JsonUtils;
import com.vainglory.utils.ValidatorUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service("passwordLoginValidService")
public class PasswordLoginValidServiceImpl implements ILoginValidService {
  @Autowired
  private IUserService userService;

  @Override
  public R<User> login(String body, Client client) {
    PasswordLoginReq loginBody = JsonUtils.parseObject(body, PasswordLoginReq.class);
    ValidatorUtils.validate(loginBody);
    if (loginBody == null) {
      return R.F(E.bad_request);
    }

    String username = loginBody.getUsername();
    String password = loginBody.getPassword();
    String code = loginBody.getCode();
    String uuid = loginBody.getUuid();

//    if (captchaService == null) {
//      return R.F(E.bad_request);
//    }

    // 检查验证码
//    if (captchaProperties.getEnable()) {
//      if (!captchaService.checkCaptcha(uuid, code)) {
//        return R.F(E.invalid_captcha);
//      }
//    }

    // 查询该用户是否存在
    QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("username", username);
    User user = userService.getOne(wrapper);
    if (user == null) {
      return R.F(E.no_user);
    }

    // 密码是否匹配
    if (!BCrypt.checkpw(password, user.getPassword())) {
      return R.F(E.invalid_user_or_password);
    }
    return R.OK(user);
  }
}
