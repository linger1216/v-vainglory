package com.vainglory.common.core.enums;

/*
  错误码定义
 */


public enum ResponseEnum {
  OK(0, "success"),
  RC1001(1001, "用户名密码错误"),
  RC1002(1002, "未授权的资源"),
  RC1003(1003, "未授权的资源"),
  RC1005(1005, "缺少请求体参数异常"),
  RC1006(1006, "参数绑定异常"),
  RC1007(1007, "方法参数无效异常"),
  RC1400(1400, "参数异常"),
  RC1401(1401, "用户未授权"),
  RC1403(1403, "请求被禁止"),
  RC1500(1500, "服务器异常");

  ResponseEnum(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public Integer getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }

  private final Integer code;
  private final String msg;
}
