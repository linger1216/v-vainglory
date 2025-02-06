package com.vainglory.common.core.constant;

import com.vainglory.common.core.enums.ResponseEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*
  统一返回值
 */
@Data
@NoArgsConstructor
public class R<T> implements Serializable {
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

    R<T> r = new R<>();
    r.setCode(0);
    r.setData(data);
    r.setMsg("success");
    return r;

//    return new R<>(Constants.CODE_SUCCESS, "success", data);
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
