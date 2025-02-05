package com.vainglory.system.controller;

import com.vainglory.common.core.utils.MapstructUtils;
import com.vainglory.system.domain.User;
import com.vainglory.system.domain.dto.CreateUserReq;
import com.vainglory.system.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private IUserService userService;

  @PostMapping
  public User create(@Validated @RequestBody CreateUserReq req) {
    User user = MapstructUtils.convert(req, User.class);
    boolean result = userService.save(user);
    if (!result) {
      log.debug("创建用户失败");
    }
    return user;
  }

  @GetMapping
  public List<User> get() {
    List<User> users = userService.list();
    return users;
  }
}
