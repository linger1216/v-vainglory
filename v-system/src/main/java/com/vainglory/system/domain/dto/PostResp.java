package com.vainglory.system.domain.dto;

import com.vainglory.common.mybatis.domain.dto.BaseResp;
import com.vainglory.system.domain.Dept;
import com.vainglory.system.domain.User;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;


@Data
@AutoMapper(target = User.class)
public class PostResp extends BaseResp {
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
   * 部门id
   */
  private String deptId;

  /**
   * 显示排序
   */
  private String sort;

  /**
   * 部门详情
   */
  private DeptResp dept;
}
