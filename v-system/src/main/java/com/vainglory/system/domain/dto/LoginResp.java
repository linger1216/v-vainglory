package com.vainglory.system.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class LoginResp {
  /**
   * 授权令牌
   */
  private String accessToken;

  /**
   * 刷新令牌
   */
  private String refreshToken;

  /**
   * 授权令牌 access_token 的有效期
   */
  private Long expireIn;

  /**
   * 刷新令牌 refresh_token 的有效期
   */
  private Long refreshExpireIn;

  /**
   * 应用id
   * 用于区别登录方式, 比如A应用只支持手机登录, B应用支持手机和密码登录, C应用支持手机、密码和微信登录
   */
  private String clientId;

  /**
   * 用户 openid
   */
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String openid;

}
