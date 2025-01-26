package com.vainglory.common;

import lombok.Data;
import org.springframework.http.HttpStatus;

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
    return new R<>(HttpStatus.OK.value(), "success", data);
  }

  public static <T> R<T> OK() {
    return new R<>(HttpStatus.OK.value(), "success");
  }

  public static <T> R<T> F(Integer code, String msg) {
    return new R<>(code, msg);
  }
  public static <T> R<T> Err(String msg) {
    return new R<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
  }
}
