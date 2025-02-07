package com.vainglory.common.core.domain;

import com.vainglory.common.core.constant.Constants;
import com.vainglory.common.core.enums.ResponseEnum;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/*
  统一返回值
 */
@Getter
@NoArgsConstructor
public class R<T> {
  private int code;
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
    return new R<>(Constants.CODE_SUCCESS, "success", data);
  }
  public static <T> R<T> OK() {
    return new R<>(Constants.CODE_SUCCESS, "success");
  }
  public static <T> R<T> F(ResponseEnum e) {
    return new R<>(e.getCode(), e.getMsg());
  }
  public static <T> R<T> F(ResponseEnum e, String msg) {
    return new R<>(e.getCode(), msg);
  }
  public static <T> R<T> F(int code, String msg) {
    return new R<>(code, msg);
  }
  public static <T> R<T> F(String msg) {
    return new R<>(Constants.CODE_FAILED, msg);
  }
}
