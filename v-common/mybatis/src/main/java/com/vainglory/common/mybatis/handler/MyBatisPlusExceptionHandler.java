package com.vainglory.common.mybatis.handler;

import com.vainglory.common.core.enums.ResponseEnum;
import com.vainglory.common.core.constant.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class MyBatisPlusExceptionHandler implements ResponseBodyAdvice<Object> {
  @Override
  public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass,
                                ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
    if (o instanceof String) {
      return R.OK(o);
    }

    if (o instanceof R) {
      return o;
    }
    return R.OK(o);
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(value = Exception.class)
  public Object exceptionHandler(Exception e) {
    log.error("系统内部异常，异常信息", e);
    return R.F(ResponseEnum.RC1500.getCode(), e.toString());
  }


  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MissingServletRequestParameterException.class)
  public Object parameterMissingExceptionHandler(MissingServletRequestParameterException e) {
    log.error("缺少Servlet请求参数异常", e);
    return R.F(ResponseEnum.RC1400);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(HttpMessageNotReadableException.class)
  public Object parameterBodyMissingExceptionHandler(HttpMessageNotReadableException e) {
    log.error("参数请求体异常", e);
    return R.F(ResponseEnum.RC1005);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(BindException.class)
  public Object validExceptionHandler(BindException e) {
    log.error("方法参数绑定错误(实体对象传参)", e);
    return R.F(ResponseEnum.RC1006);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({MethodArgumentNotValidException.class})
  public Object parameterExceptionHandler(MethodArgumentNotValidException e) {
    log.error("方法参数无效异常(实体对象请求体传参)", e);
    List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
    // concat all default message
    StringBuilder sb = new StringBuilder();
    for (ObjectError error : allErrors) {
      sb.append(error.getDefaultMessage()).append(";");
    }
    return R.F(ResponseEnum.RC1400, sb.toString());
  }

  @Override
  public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
    return true;
  }

}
