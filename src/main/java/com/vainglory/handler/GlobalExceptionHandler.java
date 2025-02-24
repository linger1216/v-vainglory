package com.vainglory.handler;

import com.vainglory.constant.Constants;
import com.vainglory.domain.R;
import com.vainglory.exception.BaseException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


/*
全局捕获异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(value = Exception.class)
  public Object exceptionHandler(Exception e) {
    return R.F(Constants.HTTP_FAILED, e.toString());
  }


//  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//  @ExceptionHandler(value = Exception.class)
//  public Object exceptionHandler(Exception e) {
//    log.error("未知异常信息", e);
//    return R.F(ResponseEnum.RC1500.getCode(), e.toString());
//  }


//
//
//  @ResponseStatus(HttpStatus.BAD_REQUEST)
//  @ExceptionHandler(MissingServletRequestParameterException.class)
//  public Object parameterMissingExceptionHandler(MissingServletRequestParameterException e) {
//    log.error("缺少Servlet请求参数异常", e);
//    return R.F(ResponseEnum.RC1400);
//  }
//
//  @ResponseStatus(HttpStatus.BAD_REQUEST)
//  @ExceptionHandler(HttpMessageNotReadableException.class)
//  public Object parameterBodyMissingExceptionHandler(HttpMessageNotReadableException e) {
//    log.error("参数请求体异常", e);
//    return R.F(ResponseEnum.RC1005);
//  }
//
//  @ResponseStatus(HttpStatus.BAD_REQUEST)
//  @ExceptionHandler(BindException.class)
//  public Object validExceptionHandler(BindException e) {
//    log.error("方法参数绑定错误(实体对象传参)", e);
//    return R.F(ResponseEnum.RC1006);
//  }
//

  //
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ConstraintViolationException.class)
  public Object validConstraintViolationExceptionHandler(ConstraintViolationException e) {
    return R.F(HttpStatus.BAD_REQUEST.value(), e.toString());
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(BaseException.class)
  public Object validBaseExceptionHandler(BaseException e) {
    return R.F(e.getCode(), e.getMsg());
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({MethodArgumentNotValidException.class})
  public Object parameterExceptionHandler(MethodArgumentNotValidException e) {
    List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
    // concat all default message
    StringBuilder sb = new StringBuilder();
    for (ObjectError error : allErrors) {
      sb.append(error.getDefaultMessage()).append(";");
    }
    return R.F(HttpStatus.BAD_REQUEST.value(), sb.toString());
  }
}
