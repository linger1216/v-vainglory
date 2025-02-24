package com.vainglory.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Client extends BaseEntity {
  /**
   * 客户端id
   */
  private String id;

  /**
   * 客户端key
   */
  private String key;

  /**
   * 客户端密钥
   */
  private String secret;

  /**
   * 客户端授权类型
   */
  private String grantType;


  /**
   * 客户端设备类型
   */
  private String deviceType;

  /**
   * token 有效期（单位：秒）
   */
  private Integer timeout;

  /**
   * token 最低活跃频率（单位：秒
   */
  private Integer activeTimeout;
}
