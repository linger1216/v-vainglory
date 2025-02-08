package com.vainglory.common.captcha.service.impl;

import com.vainglory.common.captcha.service.ICaptchaService;
import org.springframework.stereotype.Service;

@Service
public class DefaultCaptchaService implements ICaptchaService {
  @Override
  public String getCaptcha(String id) {
    return "1234";
  }

  @Override
  public boolean checkCaptcha(String id, String code) {
    return true;
  }
}
