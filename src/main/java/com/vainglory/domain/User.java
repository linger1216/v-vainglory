package com.vainglory.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.vainglory.domain.dto.RouterResp;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Accessors(chain = true)
public class User extends BaseEntity {
  private String id;
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


  /**
   * 用户所属多个部门
   */
  @TableField(exist = false)
  private List<Dept> depts;

  /**
   * 用户所属多个角色
   */
  @TableField(exist = false)
  private List<Role> roles;


  /**
   * 用户所属路由，其实就是菜单转过来的
   */
  @TableField(exist = false)
  private List<RouterResp> routers;

  /**
   * 用户所属多个岗位
   */
  @TableField(exist = false)
  private List<Post> posts;
}
