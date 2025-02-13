package com.vainglory.common.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.vainglory.common.core.service.IErrorCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.vainglory.common.core.constant.BaseErrorCode.FAILED;
import static com.vainglory.common.core.constant.BaseErrorCode.SUCCESS;

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
    return this.code == SUCCESS;
  }

  @JsonIgnore
  public Boolean isFailed() {
    return this.code != SUCCESS;
  }

  public static <T> R<T> OK(T data) {
    return new R<>(SUCCESS, "success", data);
  }

  public static <T> R<T> OK() {
    return new R<>(SUCCESS, "success");
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
    return new R<>(FAILED, msg);
  }
}
