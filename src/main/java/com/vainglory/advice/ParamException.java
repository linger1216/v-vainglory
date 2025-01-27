package com.vainglory.advice;

import com.vainglory.common.R;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ParamException {

  @ExceptionHandler({MethodArgumentNotValidException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public R handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
    BindingResult bindingResult = ex.getBindingResult();
    StringBuilder sb = new StringBuilder("校验失败:");
    for (FieldError fieldError : bindingResult.getFieldErrors()) {
      sb.append(fieldError.getField()).append("：").append(fieldError.getDefaultMessage()).append(", ");
    }
    String msg = sb.toString();
    return R.F(HttpStatus.BAD_REQUEST.value(),msg);
  }

  @ExceptionHandler({ConstraintViolationException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public R handleConstraintViolationException(ConstraintViolationException ex) {
    return R.F(HttpStatus.BAD_REQUEST.value(),ex.getMessage());
  }
}
