package com.vainglory.system.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vainglory.common.mybatis.domain.dto.BaseReq;
import com.vainglory.system.domain.User;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginReq extends BaseReq {

  /**
   * 客户端id
   */
  @NotBlank
  private String clientId;

  /**
   * 租户ID
   */
  @NotBlank
  private String tenantId;

  /**
   * 授权类型
   */
  @NotBlank(message = "授权类型不能为空")
  @Pattern(regexp = "^(password|sms|social|xcx|email)$", message = "授权类型错误")
  private String grantType;

  /**
   * 验证码
   */
  private String code;

  /**
   * 唯一标识
   */
  private String uuid;
}
