package com.vainglory.system.domain.dto;

import com.vainglory.common.core.utils.StringUtils;
import lombok.Data;

/**
 * 路由显示信息
 *
 */

@Data
public class MetaResp {

    /**
     * 设置该路由在侧边栏和面包屑中展示的名字
     */
    private String title;

    /**
     * 设置该路由的图标，对应路径src/assets/icons/svg
     */
    private String icon;

    /**
     * 设置为true，则不会被 <keep-alive>缓存
     */
    private boolean keepAlive;

    /**
     * 内链地址（http(s)://开头）
     */
    private String link;

    public MetaResp(String title, String icon) {
        this.title = title;
        this.icon = icon;
    }

    public MetaResp(String title, String icon, boolean keepAlive) {
        this.title = title;
        this.icon = icon;
        this.keepAlive = keepAlive;
    }

    public MetaResp(String title, String icon, String link) {
        this.title = title;
        this.icon = icon;
        this.link = link;
    }

    public MetaResp(String title, String icon, boolean keepAlive, String link) {
        this.title = title;
        this.icon = icon;
        this.keepAlive = keepAlive;
        this.link = link;
    }

}
