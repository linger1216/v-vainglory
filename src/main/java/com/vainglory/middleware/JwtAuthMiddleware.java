package com.vainglory.middleware;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vainglory.domain.R;
import com.vainglory.enums.E;
import com.vainglory.properties.security.SecurityProperties;
import com.vainglory.service.IErrorCode;
import com.vainglory.utils.login.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Slf4j
@Component
@EnableConfigurationProperties(SecurityProperties.class)
public class JwtAuthMiddleware implements Filter {

  @Autowired
  private JwtUtils jwtUtils;

  @Autowired
  private SecurityProperties securityProperties;

  @Value("${server.servlet.context-path}")
  private String serverPath;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  private void sendErrorResponse(HttpServletResponse response, IErrorCode error) throws IOException {
    response.setStatus(HttpStatus.UNAUTHORIZED.value());
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json;charset=UTF-8");
    response.getWriter().write(new ObjectMapper().writeValueAsString(R.F(error)));
  }

  private boolean isExcludedPath(String requestPath) {
    List<String> excludes = securityProperties.getExcludes();
    return excludes != null &&
      excludes.stream()
        .map(exclude -> this.serverPath + exclude)
        .anyMatch(requestPath::startsWith);
  }

  private String getTokenFromHeader(HttpServletRequest request) {
    String tokenHeader = request.getHeader(jwtUtils.getTokenName());
    if (tokenHeader == null || !tokenHeader.startsWith("Bearer ")) {
      return null;
    }
    return tokenHeader.substring(7);
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
    throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;

    // 检查是否在排除列表中
    if (isExcludedPath(request.getRequestURI())) {
      chain.doFilter(request, response);
      log.info("请求路径在排除列表中，直接放行");
      return;
    }

    // 从头中取出header
    String token = getTokenFromHeader(request);
    if (token == null) {
      sendErrorResponse(response, E.no_authorization);
      return;
    }

    // 验证token并获取claims
    // 这里为什么要使用try，而不是抛出异常给Global处理
    // 因为在filter的过程中，Global还没有初始化，所以Global不会生效
    try {
      Claims claims = jwtUtils.validateToken(token);
      if (claims == null) {
        sendErrorResponse(response, E.invalid_token);
        return;
      }

      // 正常路径,设置用户信息并继续处理
      request.setAttribute("userId", claims.get("userId"));
      chain.doFilter(request, response);
    } catch (ExpiredJwtException e) {
      sendErrorResponse(response, E.token_expired);
    } catch (JwtException e) {
      sendErrorResponse(response, E.invalid_token);
    }
  }

  @Override
  public void destroy() {
  }
}
