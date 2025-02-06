package com.vainglory.system.domain;

import com.vainglory.common.mybatis.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Menu extends BaseEntity {
  /**
   * 菜单id
   */
  private String id;

  /**
   * 菜单名称
   */
  private String name;

  /**
   * 菜单图标
   */
  private String icon;

  /**
   * 父菜单id
   */
  private String parentId;


  /**
   * 对应前端组件
   */
  private String component;

  /**
   * 路由地址
   */
  private String path;

  /**
   * 路由参数
   */
  private String queryParam;

  /**
   * 在前端是否缓存 1缓存 0不缓存
   */
  private String keepAlive;

  /**
   * 是否为外链（1是 0否）
   */
  private String isExternal;

  /**
   * 菜单类型,0目录 1菜单 2按钮
   */
  private String type;

  /**
   * 权限标识
   */
  private String perms;


  /**
   * 显示排序
   */
  private Integer sort;
}
