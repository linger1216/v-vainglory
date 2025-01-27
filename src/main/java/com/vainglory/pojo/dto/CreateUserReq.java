package com.vainglory.pojo.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CreateUserReq extends BaseDto{
  private String avatar;

  @Size(min = 2, max = 12, message = "昵称长度必须在2-12个字符之间")
  private String nickname;

  @Pattern(regexp = "^[a-zA-Z0-9]{4,20}$", message = "用户名必须由4-20个字母或数字组成")
  private String username;

  @Size(min = 6, max = 20, message = "密码长度必须在6-20个字符之间")
  private String password;

  @Email
  private String email;

  @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确")
  private String phone;

  private String address;
}
