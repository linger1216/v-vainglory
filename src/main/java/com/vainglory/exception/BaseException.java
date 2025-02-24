package com.vainglory.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 基础异常
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class BaseException extends RuntimeException {
  private Integer code;
  private String msg;
}
