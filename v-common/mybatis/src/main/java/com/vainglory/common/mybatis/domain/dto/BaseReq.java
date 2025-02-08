package com.vainglory.common.mybatis.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseReq implements Serializable {

  /**
   * 状态: 1正常 0禁用
   */
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Integer status;

  /**
   * 开始时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Date startTime;

  /**
   * 结束时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Date endTime;
}
