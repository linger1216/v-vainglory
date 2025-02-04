package com.vainglory.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lid
 * @since 2025-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Menu extends BaseEntity {


    /**
     * id
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 图标
     */
    private String icon;

    /**
     * 对应前端组件
     */
    private String component;

    /**
     * url路径
     */
    private String path;

    /**
     * 父ID,如果为空,则代表一级菜单
     */
    private String parentId;

    /**
     * 在前端是否保活 1正常 0禁用
     */
    private Integer keepAlive;

    /**
     * 排序规则
     */
    private Integer sort;
}
