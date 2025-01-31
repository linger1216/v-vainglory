package com.vainglory.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {

  @TableField(fill = FieldFill.INSERT)
  private Integer status;

  @TableField(fill = FieldFill.INSERT, value = "create_by")
  private String createBy;

  @TableField(fill = FieldFill.INSERT_UPDATE, value = "update_by")
  private String updateBy;

  @Version
  private Integer version;

  @TableField(fill = FieldFill.INSERT,select = false)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 注解用于指定从前台接受的时间字符串格式，若格式不对应则抛出异常
  private Date createTime;


  @TableField(fill = FieldFill.INSERT_UPDATE,select = false)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date updateTime;

  @TableLogic
  @TableField(select = false)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date deleteTime;
}
