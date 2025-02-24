package com.vainglory.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Api extends BaseEntity {
  /**
   * Api id
   */
  private String id;

  /**
   * Api名称
   */
  private String name;

  /**
   * Api描述
   */
  private String description;

  /**
   * Api方法
   */
  private String method;

  /**
   * Api路径
   */
  private String path;

  /**
   * 是否鉴权: 1公开 0私有
   */
  private Integer access;

  /**
   * 对应实体进行分组
   */
  private String entity;
}
