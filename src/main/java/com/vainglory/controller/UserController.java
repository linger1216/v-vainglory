package com.vainglory.controller;

import com.vainglory.domain.*;
import com.vainglory.domain.dto.RouterResp;
import com.vainglory.enums.E;
import com.vainglory.service.IDeptService;
import com.vainglory.service.IMenuService;
import com.vainglory.service.IRoleService;
import com.vainglory.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


  /**
   * 获取用户信息
   *
   * @return 用户信息
   */
  @GetMapping("/getInfo")
  public R<User> getInfo() {
    return null;
  }


  /**
   * 根据用户编号获取详细信息
   *
   * @param userId 用户ID
   */
//  @SaCheckPermission("user.get")
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
    user.setRoles(roles);


    // 角色的菜单
    // 如果一个人拥有多个角色，前端在处理逻辑的时候要将多个角色的router合并
    // 所以role里就不分开查了，在user测统一查询
    //    for (Role role : roles) {
    //      List<Menu> menus = menuService.getMenusByRoleId(role.getId());
    //      if (menus != null && !menus.isEmpty()) {
    //        List<RouterResp> routerResps = menuService.buildTrees(menus);
    //        role.setRouters(routerResps);
    //      }
    //    }

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
