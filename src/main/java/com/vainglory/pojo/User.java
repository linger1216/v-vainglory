package com.vainglory.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
public class User extends BaseEntity{
  @TableId(type = IdType.ASSIGN_ID)
  private String id;
  private String avatar;
  private String nickname;
  private String username;
  private String password;
  private String salt;
  private String email;
  private String phone;
  private String address;
  @TableField(value = "dept_id")
  private String deptId;
  @TableField(value = "role_id")
  private String roleId;
  @TableField(value = "post_id")
  private String postId;
}
