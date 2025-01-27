package com.vainglory.common;

import lombok.Data;

/*
  统一返回值
 */


@Data
public class R<T> {
  private Integer code;
  private String msg;
  private T data;

  public R(int code, String msg, T data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
  }

  public R(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public static <T> R<T> OK(T data) {
    return new R<>(Constants.R_CODE_SUCCESS, "success", data);
  }
  public static <T> R<T> OK() {
    return new R<>(Constants.R_CODE_SUCCESS, "success");
  }

  public static <T> R<T> F(ResponseEnum e) {
    return new R<>(e.getCode(), e.getMsg());
  }

  public static <T> R<T> F(ResponseEnum e, String msg) {
    return new R<>(e.getCode(), msg);
  }

  public static <T> R<T> F(Integer code, String msg) {
    return new R<>(code, msg);
  }
  public static <T> R<T> F(String msg) {
    return new R<>(Constants.R_CODE_FAILED, msg);
  }
}
