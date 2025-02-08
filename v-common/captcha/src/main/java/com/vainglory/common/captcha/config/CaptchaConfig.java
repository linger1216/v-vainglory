package com.vainglory.common.captcha.config;

import com.vainglory.common.captcha.properties.CaptchaProperties;
import com.vainglory.common.captcha.service.ICaptchaService;
import com.vainglory.common.captcha.service.impl.DefaultCaptchaService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * 验证码配置
 *
 */
@AutoConfiguration
@EnableConfigurationProperties(CaptchaProperties.class)
public class CaptchaConfig {

  @Bean
  public ICaptchaService captchaService(CaptchaProperties captchaProperties) {
    return new DefaultCaptchaService();
  }
}
