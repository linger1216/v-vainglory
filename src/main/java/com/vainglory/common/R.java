package com.vainglory.common;

import org.springframework.http.HttpStatus;

public class R {
  private Integer code;
  private String msg;
  private Object data;

  public R(int code, String msg, Object data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
  }

  public R(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public static R OK(Object data) {
    return new R(HttpStatus.OK.value(), "success", data);
  }
  public static R OK() {
    return new R(HttpStatus.OK.value(), "success");
  }

  public static R F(Integer code, String msg) {
    return new R(code, msg);
  }
  public static R Err(String msg) {
    return new R(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
  }
}
