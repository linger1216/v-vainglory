package com.vainglory.system.service;

import com.vainglory.system.domain.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.vainglory.system.domain.dto.RouterResp;

import java.util.List;

/**
* @author lid
* @description 针对表【t_menu】的数据库操作Service
* @createDate 2025-02-10 23:01:57
*/
public interface IMenuService extends IService<Menu> {
  List<Menu> getMenusByRoleId(String roleId);
  List<Menu> getMenusByUserId(String userId);
  List<RouterResp> buildTrees(List<Menu> menus);
}
