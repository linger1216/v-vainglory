package com.vainglory.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {

  /**
   * 租户id
   */
  private String tenantId;

  /**
   * 状态: 1正常 0禁用
   */
  @TableField(fill = FieldFill.INSERT)
  private Integer status;

  /**
   * 创建者部门
   * 数据权限过滤,默认不序列化,
   */
  @JsonIgnore
  @TableField(fill = FieldFill.INSERT)
  private String createDept;

  /**
   * 创建者
   */
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @TableField(fill = FieldFill.INSERT)
  private String createBy;

  /**
   * 更新者
   */
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private String updateBy;

  /**
   * 乐观锁
   */
  @JsonIgnore
  @Version
  private Integer version;

  /**
   * 创建时间
   * 注解用于指定从前台接受的时间字符串格式，若格式不对应则抛出异常
   */
  @TableField(fill = FieldFill.INSERT)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date createTime;

  /**
   * 更新时间
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date updateTime;

  /**
   * 删除时间(逻辑删除)
   */
  @TableLogic
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Date deleteTime;
}
