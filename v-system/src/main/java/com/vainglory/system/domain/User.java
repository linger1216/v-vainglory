package com.vainglory.system.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.vainglory.common.mybatis.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User extends BaseEntity {
  private String id;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String avatar;
  private String nickname;
  private String description;
  private String username;
  @JsonIgnore
  private String password;
  @JsonIgnore
  private String salt;
  private String email;
  private String phone;
  private String address;
}
