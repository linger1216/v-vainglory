package com.vainglory.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User extends BaseEntity{
  @TableId(type = IdType.ASSIGN_ID)
  private String Id;
  private String avatar;
  private String nickname;
  private String username;
  private String password;
  private String salt;
  private String email;
  private String phone;
  private String address;
  private String deptId;
  private String roleId;
  private String postId;
}
