package com.vainglory.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
public class Version {
  @TableId(type = IdType.ASSIGN_ID)
  private String id;
  private String version;
  private String description;
}
