package com.vainglory.common.core.advice;

import com.vainglory.common.core.domain.R;
import com.vainglory.common.core.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/*
全局返回值
 */
@Slf4j
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

  @Override
  public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass,
                                ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

    // 坑: controller返回string,会把media-type改成text/plain
    if (o instanceof String) {
      return JsonUtils.toJsonString(R.OK(o));
    }
    if (o instanceof R) {
      return o;
    }
    return R.OK(o);
  }

  @Override
  public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
    return true;
  }
}
