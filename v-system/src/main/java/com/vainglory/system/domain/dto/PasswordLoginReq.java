package com.vainglory.system.domain.dto;

import com.vainglory.common.mybatis.domain.dto.BaseReq;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PasswordLoginReq extends LoginReq {
  @Pattern(regexp = "^[a-zA-Z0-9_]{4,20}$", message = "用户名必须由4-20个字母或数字组成")
  private String username;

  @Size(min = 6, max = 20, message = "密码长度必须在6-20个字符之间")
  private String password;
}
