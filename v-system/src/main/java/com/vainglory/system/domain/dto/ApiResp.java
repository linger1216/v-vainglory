package com.vainglory.system.domain.dto;

import com.vainglory.common.mybatis.domain.dto.BaseResp;
import com.vainglory.system.domain.User;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;


@Data
@AutoMapper(target = User.class)
public class ApiResp extends BaseResp {
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
