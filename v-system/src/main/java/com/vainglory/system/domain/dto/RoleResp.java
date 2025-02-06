package com.vainglory.system.domain.dto;

import com.vainglory.common.mybatis.domain.dto.BaseResp;
import com.vainglory.system.domain.User;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.util.List;


@Data
@AutoMapper(target = User.class)
public class RoleResp extends BaseResp {
  private String id;
  private String name;
  private String description;
  private String key;
  private String sort;
  /**
   * 数据范围
   * 1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
   */
  private Integer dataScope;

  /**
   * 角色关联的菜单
   */
  private List<MenuResp> menus;

  /**
   * 角色关联的Api
   */
  private List<ApiResp> apis;

  /**
   * 数据范围: 2 自定数据权限
   * 有自定义部门资源权限, 跟多少个部门关联
   */
  private List<DeptResp> depts;
}
