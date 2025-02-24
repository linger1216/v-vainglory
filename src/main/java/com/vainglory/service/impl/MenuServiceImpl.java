package com.vainglory.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vainglory.constant.Constants;
import com.vainglory.domain.Menu;
import com.vainglory.domain.dto.MetaResp;
import com.vainglory.domain.dto.RouterResp;
import com.vainglory.mapper.MenuMapper;
import com.vainglory.service.IMenuService;
import com.vainglory.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
* @author lid
* @description 针对表【t_menu】的数据库操作Service实现
* @createDate 2025-02-10 23:01:57
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements IMenuService {


  @Autowired
  private MenuMapper menuMapper;

  @Override
  public List<Menu> getMenusByRoleId(String roleId) {
    List<Menu> menus = menuMapper.getMenusByRoleId(roleId);
    return menus;
  }

  @Override
  public List<Menu> getMenusByUserId(String userId) {
    List<Menu> menus = menuMapper.getMenusByUserId(userId);
    return menus;
  }

  @Override
  public List<RouterResp> buildTrees(List<Menu> menus) {
    if (CollUtil.isEmpty(menus)) {
      return null;
    }

    Map<String, RouterResp> routerMap = new HashMap<>();
    // 但为了保证排序,在此确认一下
    // false 在前， true在后
    List<Menu> sortedMenus = menus.stream()
      .sorted(Comparator.comparing(menu -> menu.getType() != Constants.MENU_TYPE_DIRECTORY ))
      .toList();

    // 构建路由映射
    for (Menu menu : sortedMenus) {
      RouterResp router = new RouterResp();
      router.setId(menu.getId());
      router.setName(menu.getName());
      router.setPath(menu.getPath());
      router.setType(menu.getType());
      router.setComponent(menu.getComponent());
      router.setQueryParam(menu.getQueryParam());
      router.setMeta(new MetaResp(menu.getTitle(), menu.getIcon(),
        menu.getKeepAlive() == 1, menu.getPath()));
      routerMap.put(router.getId(), router);
    }

    List<RouterResp> routers = new ArrayList<>();
    // 再次遍历所有菜单，构建树结构
    for (Menu menu : sortedMenus) {
      // 如果是根菜单，直接加入到根菜单列表
      if (StringUtils.isEmpty(menu.getParentId())) {
        routers.add(routerMap.get(menu.getId()));
      } else {
        // 如果不是根菜单，找到其父菜单并添加到父菜单的children中
        RouterResp parentMenu = routerMap.get(menu.getParentId());
        if (parentMenu != null) {
          if (parentMenu.getChildren() == null) {
            parentMenu.setChildren(new ArrayList<>());
          }
          parentMenu.getChildren().add(routerMap.get(menu.getId()));
        }
      }
    }
    return routers;
  }
}




