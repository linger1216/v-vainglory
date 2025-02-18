package com.vainglory.system.controller;

import com.vainglory.common.core.domain.R;
import com.vainglory.common.core.utils.MapstructUtils;
import com.vainglory.system.domain.Dept;
import com.vainglory.system.domain.Menu;
import com.vainglory.system.domain.Role;
import com.vainglory.system.domain.User;
import com.vainglory.system.domain.dto.RoleResp;
import com.vainglory.system.domain.dto.RouterResp;
import com.vainglory.system.domain.dto.UserResp;
import com.vainglory.system.enums.E;
import com.vainglory.system.service.IDeptService;
import com.vainglory.system.service.IMenuService;
import com.vainglory.system.service.IRoleService;
import com.vainglory.system.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
  public R<UserResp> getUserInfo(@PathVariable String userId) {
    User user = userService.getById(userId);
    if (user == null) {
      return R.F(E.no_user);
    }

    UserResp userResp = MapstructUtils.convert(user, UserResp.class);
    if (userResp == null) {
      return R.F(E.bad_request);
    }

    // 用户所属部门
    List<Dept> depts = deptService.getDeptsByUserId(user.getId());
    if (depts != null && !depts.isEmpty()) {
      userResp.setDepts(depts);
    }

    // 用户所属权限
    List<Role> roles = roleService.getRolesByUserId(user.getId());
    List<RoleResp> roleResps = new ArrayList<>();
    for (Role role : roles) {
      RoleResp roleResp = MapstructUtils.convert(role, RoleResp.class);
      assert roleResp != null;
      List<Menu> menus = menuService.getMenusByRoleId(role.getId());
      if (menus != null && !menus.isEmpty()) {
        List<RouterResp> routerResps = menuService.buildTrees(menus);
        roleResp.setRouters(routerResps);
      }
      roleResps.add(roleResp);
    }

    userResp.setRoles(roleResps);
    return R.OK(userResp);
  }


  @GetMapping
  public List<User> get() {
    List<User> users = userService.list();
    return users;
  }
}
