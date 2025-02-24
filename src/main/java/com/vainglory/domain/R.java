package com.vainglory.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.vainglory.constant.Constants;
import com.vainglory.service.IErrorCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
  统一返回值
 */
@Getter
@NoArgsConstructor
public class R<T> {
  private int code;
  private String msg;

  @JsonInclude(JsonInclude.Include.NON_NULL)
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

  @JsonIgnore
  public Boolean isSuccess() {
    return this.code == Constants.HTTP_SUCCESS;
  }

  @JsonIgnore
  public Boolean isFailed() {
    return this.code != Constants.HTTP_SUCCESS;
  }

  public static <T> R<T> OK(T data) {
    return new R<>(Constants.HTTP_SUCCESS, "success", data);
  }

  public static <T> R<T> OK() {
    return new R<>(Constants.HTTP_SUCCESS, "success");
  }
  public static <T> R<T> F(IErrorCode e) {
    return new R<>(e.getCode(), e.getMsg());
  }
  public static <T> R<T> F(R<?> e) {
    return new R<>(e.getCode(), e.getMsg());
  }
  public static <T> R<T> F(int code, String msg) {
    return new R<>(code, msg);
  }
  public static <T> R<T> F(String msg) {
    return new R<>(Constants.HTTP_FAILED, msg);
  }
}
