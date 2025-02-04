package com.vainglory.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
public class User extends BaseEntity{
  private String id;
  private String avatar;
  private String nickname;
  private String username;
  private String password;
  private String salt;
  private String email;
  private String phone;
  private String address;
  @TableField(value = "dept_ids")
  private String[] deptIds;
  @TableField(value = "role_ids")
  private String[] roleIds;
  @TableField(value = "post_ids")
  private String[] postIds;
}
