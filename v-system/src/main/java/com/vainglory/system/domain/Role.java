package com.vainglory.system.domain;

import com.vainglory.common.mybatis.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Role extends BaseEntity {
  /**
   * 角色id
   */
  private String id;

  /**
   * 角色名称
   */
  private String name;

  /**
   * 角色描述
   */
  private String description;

  /**
   * 角色权限
   */
  private String key;

  /**
   * 显示排序
   */
  private Integer sort;

  /**
   * 数据范围
   * 1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
   */
  private Integer dataScope;
}
