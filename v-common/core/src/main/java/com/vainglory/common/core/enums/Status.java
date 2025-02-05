package com.vainglory.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    ENABLE(1, "启用"),
    DISABLE(0, "禁用");
    private final Integer code;
    private final String description;
}
