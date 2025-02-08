package com.vainglory.system.service.impl;

import cn.dev33.satoken.secure.BCrypt;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vainglory.common.captcha.properties.CaptchaProperties;
import com.vainglory.common.captcha.service.ICaptchaService;
import com.vainglory.common.core.domain.R;
import com.vainglory.common.core.utils.JsonUtils;
import com.vainglory.common.core.utils.ValidatorUtils;
import com.vainglory.system.domain.Client;
import com.vainglory.system.domain.User;
import com.vainglory.system.domain.dto.PasswordLoginReq;
import com.vainglory.system.enums.E;
import com.vainglory.system.service.ILoginService;
import com.vainglory.system.service.IUserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PasswordLoginService implements ILoginService {
  private IUserService userService;
  private ICaptchaService captchaService;
  private CaptchaProperties captchaProperties;

  @Override
  public R<User> login(String body, Client client) {
    PasswordLoginReq loginBody = JsonUtils.parseObject(body, PasswordLoginReq.class);
    ValidatorUtils.validate(loginBody);
    if (loginBody == null) {
      return R.F(E.bad_request);
    }

    String tenantId = loginBody.getTenantId();
    String username = loginBody.getUsername();
    String password = loginBody.getPassword();
    String code = loginBody.getCode();
    String uuid = loginBody.getUuid();

    // 检查验证码
    if (captchaProperties.getEnable()) {
      if (!captchaService.checkCaptcha(uuid, code)) {
        return R.F(E.invalid_captcha);
      }
    }

    // 查询该用户是否存在
    QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("username", username);
    User user = userService.getOne(wrapper);
    if (user == null) {
      return R.F(E.no_user);
    }

    // 检查用户的租户等信息
    if (!user.getTenantId().equals(tenantId)) {
      return R.F(E.invalid_tenant);
    }

    // 密码是否匹配
    if (!BCrypt.checkpw(password, user.getPassword())) {
      return R.F(E.invalid_user_or_password);
    }
    return R.OK(user);
  }
}
