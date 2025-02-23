package com.vainglory.system.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.vainglory.common.mybatis.domain.BaseEntity;
import com.vainglory.system.domain.dto.ApiResp;
import com.vainglory.system.domain.dto.RouterResp;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
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


  /**
   * 角色关联的菜单
   */
  @TableField(exist = false)
  private List<RouterResp> routers;

  /**
   * 角色关联的Api
   */
  @TableField(exist = false)
  private List<ApiResp> apis;

  /**
   * TODO: 等到数据权限的时候再说.
   * 数据范围: 2 自定数据权限
   * 有自定义部门资源权限, 跟多少个部门关联
   */
  @TableField(exist = false)
  private List<String> deptIds;
}
