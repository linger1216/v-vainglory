package com.vainglory.utils.login;

import cn.hutool.core.lang.UUID;
import com.vainglory.properties.login.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;
import javax.crypto.SecretKey;

@Component
@EnableConfigurationProperties(JwtProperties.class)
public class JwtUtils {

  private final SecretKey SECRET_KEY;

  public static final int DEFAULT_ACCESS_EXPIRE_SECONDS = 21600;

  /**
   * 默认过期时间(单位:秒) 值为 6小时
   */
  private long EXPIRE;

  /**
   * 加密算法
   */
  private static final SecureDigestAlgorithm<SecretKey, SecretKey> ALGORITHM = Jwts.SIG.HS256;

  public JwtUtils(@Autowired JwtProperties jwtProperties) {
    this.SECRET_KEY = Keys.hmacShaKeyFor(jwtProperties.getJwtSecretKey().getBytes());
    if (jwtProperties.getTimeout() == 0) {
      jwtProperties.setTimeout(DEFAULT_ACCESS_EXPIRE_SECONDS);
    }
    this.EXPIRE = jwtProperties.getTimeout();
  }

  /**
   * jwt签发者
   */
  private static final String JWT_ISS = "jellyfish";

  /**
   * jwt主题
   */
  private static final String SUBJECT = "subject";

  /*
  这些是一组预定义的声明，它们不是强制性的，而是推荐的，以提供一组有用的、可互操作的声明。
  iss: jwt签发者
  sub: jwt所面向的用户
  aud: 接收jwt的一方
  exp: jwt的过期时间，这个过期时间必须要大于签发时间
  nbf: 定义在什么时间之前，该jwt都是不可用的.
  iat: jwt的签发时间
  jti: jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击
   */
  public String genAccessToken(String userId) {
    String uuid = UUID.randomUUID().toString();
    Date exprireDate = Date.from(Instant.now().plusSeconds(this.EXPIRE));
    return Jwts.builder()
      // 设置头部信息header
      .header()
      .add("typ", "JWT")
      .add("alg", "HS256")
      .and()
      // 设置自定义负载信息payload
      .claim("userId", userId)
      // 令牌ID
      .id(UUID.randomUUID().toString())
      // 过期日期
      .expiration(exprireDate)
      // 签发时间
      .issuedAt(new Date())
      // 主题
      .subject(SUBJECT)
      // 签发者
      .issuer(JWT_ISS)
      // 签名
      .signWith(SECRET_KEY, ALGORITHM)
      .compact();
  }


  /**
   * 解析token
   * @param token token
   * @return Jws<Claims>
   */
  public Jws<Claims> parseClaim(String token) {
    return Jwts.parser()
      .verifyWith(this.SECRET_KEY)
      .build()
      .parseSignedClaims(token);
  }

  public JwsHeader parseHeader(String token) {
    return parseClaim(token).getHeader();
  }

  public Claims parsePayload(String token) {
    return parseClaim(token).getPayload();
  }
}
