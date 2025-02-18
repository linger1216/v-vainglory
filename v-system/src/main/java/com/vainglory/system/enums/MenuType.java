package com.vainglory.system.enums;

/*
  菜单类型定义
 */

import com.vainglory.common.core.service.IErrorCode;
import lombok.Getter;

@Getter
public enum MenuType {
  directory(0),
  menu(1),
  button(2);
  MenuType(Integer code) {
    this.code = code;
  }
  private final Integer code;
}
