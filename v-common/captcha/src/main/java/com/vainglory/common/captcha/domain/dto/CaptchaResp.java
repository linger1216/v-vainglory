package com.vainglory.common.captcha.domain.dto;

import lombok.Data;

@Data
public class CaptchaResp {

  /**
   * 验证码id
   */
  private String uuid;

  /**
   * 验证码图片
   */
  private String img;
}
