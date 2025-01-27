package com.vainglory.pojo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class BaseDto {
  @Value("1")
  @Max(value = 1, message = "状态值正常")
  @Min(value = 0, message = "状态值禁用")
  private Integer status;
}
