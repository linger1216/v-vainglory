package com.vainglory.common.captcha.config;

import com.vainglory.common.captcha.properties.CaptchaProperties;
import com.vainglory.common.captcha.service.ICaptchaService;
import com.vainglory.common.captcha.service.impl.DefaultCaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 验证码配置
 *
 */
@Configuration
@EnableConfigurationProperties(CaptchaProperties.class)
public class CaptchaConfig {
  private CaptchaProperties captchaProperties;
  @Bean
  public ICaptchaService captchaService() {
    return new DefaultCaptchaService();
  }
}
