package com.vainglory.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginReq {

  /**
   * 客户端id
   */
  @NotBlank
  private String clientId;

  /**
   * 租户ID
   * 暂时注释
   * 因为通过clientId 获取 tenantId, 这个逻辑粗想没啥问题, 后面有了问题再说.
   *
   * 2025/02/23 这里是用户给与的tenantId, 不一定是正确的, 应该用这个和后端比对.
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
