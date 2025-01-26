package com.vainglory.pojo.dto;

import lombok.Data;

@Data
public class CreateUserReq {
  private String avatar;
  private String nickname;
  private String username;
  private String password;
  private String salt;
  private String email;
  private String phone;
  private String address;
}
