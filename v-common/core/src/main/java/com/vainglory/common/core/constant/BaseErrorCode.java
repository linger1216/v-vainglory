package com.vainglory.common.core.constant;


import org.springframework.http.HttpStatus;

public interface BaseErrorCode {
  Integer SUCCESS = 0;
  Integer FAILED = HttpStatus.INTERNAL_SERVER_ERROR.value();
}
