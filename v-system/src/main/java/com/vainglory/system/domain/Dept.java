package com.vainglory.system.domain;

import com.vainglory.common.mybatis.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Dept extends BaseEntity {
  /**
   * 岗位id
   */
  private String id;

  /**
   * 岗位名称
   */
  private String name;

  /**
   * 岗位描述
   */
  private String description;

  /**
   * 父岗位id
   */
  private String parentId;


  /**
   * 祖级列表
   */
  private String ancestors;

  /**
   * 负责人id
   */
  private String leaderId;

  /**
   * 电子邮件
   */
  private String email;

  /**
   * 手机号
   */
  private String phone;

  /**
   * 显示排序
   */
  private Integer sort;
}
