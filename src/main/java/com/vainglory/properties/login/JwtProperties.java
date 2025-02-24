package com.vainglory.properties.login;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
  /*
   token 名称（同时也是 cookie 名称）
   */
  private String tokenName;

  /*
  token 有效期（单位：秒） 默认6h天，-1 代表永久有效
   */
  private long timeout;

  /*
  jwt秘钥
   */
  private String jwtSecretKey;
}
