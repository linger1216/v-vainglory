package com.vainglory.system.domain.dto;

import com.vainglory.common.mybatis.domain.dto.BaseResp;
import com.vainglory.system.domain.Post;
import com.vainglory.system.domain.User;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.util.List;

/*
 * TODO:
 * username, phone加密
 */
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

  /**
   * 最后登录IP
   */
  private String lastLoginIp;

  /**
   * 最后登录时间
   */
  private String lastLoginDate;

  /**
   * 用户所属多个部门
   */
  private List<DeptResp> depts;

  /**
   * 用户所属多个角色
   */
  private List<RoleResp> roles;

  /**
   * 用户所属多个岗位
   */
  private List<PostResp> posts;
}
