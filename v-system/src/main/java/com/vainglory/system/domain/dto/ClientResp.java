package com.vainglory.system.domain.dto;

import com.vainglory.common.mybatis.domain.dto.BaseResp;
import com.vainglory.system.domain.Client;
import com.vainglory.system.domain.User;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.util.List;


@Data
@AutoMapper(target = Client.class)
public class ClientResp extends BaseResp {
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
  private String grant_type;


  /**
   * 客户端设备类型
   */
  private String device_type;

  /**
   * token 有效期（单位：秒）
   */
  private Integer timeout;

  /**
   * token 最低活跃频率（单位：秒
   */
  private Integer activeTimeout;
}
