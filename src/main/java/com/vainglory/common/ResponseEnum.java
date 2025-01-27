package com.vainglory.common;

/*
  错误码定义
 */

import lombok.Getter;

@Getter
public enum ResponseEnum {
  OK(Constants.R_CODE_SUCCESS, "success"),
  RC400(400, "参数异常"),
  RC401(401, "用户未授权"),
  RC403(403, "请求被禁止"),
  RC500(Constants.R_CODE_FAILED, "服务器异常"),
  RC999(999, "操作失败"),
  RC1001(1001, "用户名密码错误"),
  RC1002(1002, "未授权的资源"),
  RC1003(1003, "未授权的资源"),

  RC1005(1005, "缺少请求体参数异常"),
  RC1006(1006, "参数绑定异常"),
  RC1007(1007, "方法参数无效异常");

  ResponseEnum(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  private Integer code;
  private String msg;
}