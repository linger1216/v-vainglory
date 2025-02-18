package com.vainglory.system.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 路由配置信息
 *
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RouterResp {

    /**
     * 路由id
     */
    private String id;

    /**
     * 路由名字
     */
    private String name;


  /**
   * 路由类型（0目录，1菜单）
   */
    private Integer type;

    /**
     * 路由地址
     */
    private String path;

    /**
     * 是否隐藏路由，当设置 true 的时候该路由不会再侧边栏出现
     */
    private boolean hidden;

    /**
     * 组件地址
     */
    private String component;

    /**
     * 路由参数：如 {"id": 1, "name": "ry"}
     */
    private String queryParam;

    /**
     * 其他元素
     */
    private MetaResp meta;

    /**
     * 子路由
     */
    private List<RouterResp> children;
}
