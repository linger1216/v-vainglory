package com.vainglory.system.domain.dto;

import com.vainglory.common.mybatis.domain.dto.BaseResp;
import com.vainglory.system.domain.User;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

@Data
@AutoMapper(target = User.class)
public class UserResp extends BaseResp {
  private String id;
  private String avatar;
  private String nickname;
  private String description;
  private String username;
  private String email;
  private String phone;
  private String address;
}
