package com.vainglory.common.captcha.service;


public interface ICaptchaService {
  String getCaptcha(String id);
  boolean checkCaptcha(String id, String code);
}
