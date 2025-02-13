package com.vainglory.system.domain.dto;

import com.vainglory.common.mybatis.domain.dto.BaseReq;
import com.vainglory.system.domain.User;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@AutoMapper(target = User.class)
public class UserReq extends BaseReq {
  private String avatar;

  @Size(min = 2, max = 12, message = "昵称长度必须在2-12个字符之间")
  private String nickname;

  @Pattern(regexp = "^[a-zA-Z0-9]{4,20}$", message = "用户名必须由4-20个字母或数字组成")
  private String username;

  @Size(min = 6, max = 20, message = "密码长度必须在6-20个字符之间")
  private String password;

  @Email
  private String email;

  @NotBlank
  @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确")
  private String phone;

  private String address;
}
