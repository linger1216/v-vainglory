package com.vainglory.handler.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vainglory.domain.R;
import com.vainglory.enums.E;
import com.vainglory.properties.login.JwtProperties;
import com.vainglory.utils.login.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Slf4j
@Component
public class JwtAuthFilter implements Filter {

  public JwtAuthFilter(){
    log.info("JwtAuthFilter init");
  }

  @Autowired
  private JwtUtils jwtUtils;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
    throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
    HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

    // 验证接口，直接放行
    String requestPath = httpRequest.getRequestURI();
    if (requestPath.contains("/auth")) {
      chain.doFilter(httpRequest, httpResponse);
      log.info("验证接口，直接放行");
      return;
    }

    HttpServletResponse res = (HttpServletResponse) servletResponse;
    res.setCharacterEncoding("UTF-8");
    res.setContentType("application/json;charset=UTF-8");

    String tokenHeader = httpRequest.getHeader(jwtUtils.getTokenName());
    if (tokenHeader == null || !tokenHeader.startsWith("Bearer ")) {
      // token 头有问题.
      log.info("token头有问题");
      res.setStatus(HttpStatus.UNAUTHORIZED.value());
      R<?> error = R.F(E.no_authorization);
      res.getWriter().write(new ObjectMapper().writeValueAsString(error));
      return;
    }

    // 获取token并验证
    String token = tokenHeader.substring(7);
    Claims claims = jwtUtils.validateToken(token);
    if (claims == null) {
      // token解码有问题
      log.info("token解码有问题");
      res.setStatus(HttpStatus.UNAUTHORIZED.value());
      R<?> error = R.F(E.invalid_token);
      res.getWriter().write(new ObjectMapper().writeValueAsString(error));
    }

    // 设置请求数据
    httpRequest.setAttribute("userId", claims.get("userId"));

    // 继续执行逻辑
    chain.doFilter(httpRequest, httpResponse);
  }

  @Override
  public void destroy() {
  }
}
