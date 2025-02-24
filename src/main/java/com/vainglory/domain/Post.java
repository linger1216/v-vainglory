package com.vainglory.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Post extends BaseEntity {
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
   * 所属部门id
   */
  private String deptId;

  /**
   * 显示排序
   */
  private Integer sort;
}
