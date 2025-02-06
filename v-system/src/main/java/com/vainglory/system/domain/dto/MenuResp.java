package com.vainglory.system.domain.dto;

import com.vainglory.common.mybatis.domain.dto.BaseResp;
import com.vainglory.system.domain.User;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.util.List;


@Data
@AutoMapper(target = User.class)
public class MenuResp extends BaseResp {
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

  /**
   * 子菜单
   */
  private List<MenuResp> children;
}
