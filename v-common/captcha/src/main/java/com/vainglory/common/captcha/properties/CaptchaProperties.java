package com.vainglory.common.captcha.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "captcha")
public class CaptchaProperties {
  private Boolean enable;

  // TODO:
  // 滑动, 点击 等后面再说
  private String type;
}
