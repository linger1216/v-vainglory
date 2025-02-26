package com.vainglory.enums;

/*
  错误码定义
 */

import com.vainglory.service.IErrorCode;
import lombok.Getter;

@Getter
public enum E implements IErrorCode {
  bad_request(-400, "参数错误"),
  server_error(-500, "内部错误"),
  invalid_user_or_password(-1001, "用户名密码错误"),
  no_authorization(-1002, "用户未授权"),
  client_token_not_match(-1003, "客户端ID与Token不匹配"),
  invalid_token(-1002, "用户未授权"),

  invalid_captcha(-1601, "验证码错误"),
  no_user(-1602, "没有此用户"),
  invalid_grant_type(-1602, "登录请求在不在授权范围中"),
  invalid_tenant(-1603, "非法租户"),
  user_exist(-1604, "用户已存在"),
  user_exist_phone(-1605, "手机号已存在");
  E(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }
  private final Integer code;
  private final String msg;
}
