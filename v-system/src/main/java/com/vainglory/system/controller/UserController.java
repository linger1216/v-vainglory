package com.vainglory.system.controller;

import com.vainglory.common.core.domain.R;
import com.vainglory.system.domain.Dept;
import com.vainglory.system.domain.Menu;
import com.vainglory.system.domain.Role;
import com.vainglory.system.domain.User;
import com.vainglory.system.domain.dto.RouterResp;
import com.vainglory.system.enums.E;
import com.vainglory.system.service.IDeptService;
import com.vainglory.system.service.IMenuService;
import com.vainglory.system.service.IRoleService;
import com.vainglory.system.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private IUserService userService;

  @Autowired
  private IDeptService deptService;

  @Autowired
  private IMenuService menuService;

  @Autowired
  private IRoleService roleService;

  @GetMapping("/{userId}")
  public R<User> getUserInfo(@PathVariable String userId) {
    User user = userService.getById(userId);
    if (user == null) {
      return R.F(E.no_user);
    }

    // 用户所属部门
    List<Dept> depts = deptService.getDeptsByUserId(user.getId());
    if (depts != null && !depts.isEmpty()) {
      user.setDepts(depts);
    }


    // 用户所属权限
    List<Role> roles = roleService.getRolesByUserId(user.getId());
    for (Role role : roles) {
      List<Menu> menus = menuService.getMenusByRoleId(role.getId());
      if (menus != null && !menus.isEmpty()) {
        List<RouterResp> routerResps = menuService.buildTrees(menus);
        role.setRouters(routerResps);
      }
    }

    // 如果一个人拥有多个角色，前端在处理逻辑的时候要将多个角色的router合并
    // 这里后端来merge
    List<Menu> menus = menuService.getMenusByUserId(user.getId());
    List<RouterResp> routerResps = menuService.buildTrees(menus);
    user.setRouters(routerResps);
    return R.OK(user);
  }


  @GetMapping
  public List<User> get() {
    List<User> users = userService.list();
    return users;
  }
}
