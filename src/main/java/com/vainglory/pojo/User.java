package com.vainglory.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
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
  // 附加字段
  private String[] deptIds;
  private String[] roleIds;
  private String[] postIds;
}
