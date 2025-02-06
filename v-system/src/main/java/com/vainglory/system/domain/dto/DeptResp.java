package com.vainglory.system.domain.dto;

import com.vainglory.common.mybatis.domain.dto.BaseResp;
import com.vainglory.system.domain.User;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.util.List;


@Data
@AutoMapper(target = User.class)
public class DeptResp extends BaseResp {
  private String id;
  private String name;
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
  private String sort;

  /**
   * 子部门
   */
  private List<DeptResp> children;
}
