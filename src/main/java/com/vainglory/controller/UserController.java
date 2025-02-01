package com.vainglory.controller;

import com.vainglory.annotation.StatusNoneControl;
import com.vainglory.common.StatusConditionHelper;
import com.vainglory.pojo.dto.CreateUserReq;
import com.vainglory.pojo.User;
import com.vainglory.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private IUserService userService;

  @Autowired
  private ModelMapper modelMapper;

  @PostMapping
  public User create(@Validated @RequestBody CreateUserReq req) {
    User user = modelMapper.map(req, User.class);
    boolean result = userService.save(user);
    if (!result) {
      log.debug("创建用户失败");
    }
    return user;
  }

  @DeleteMapping
  public String delete() {
    userService.removeById(1);
    return "success";
  }

  @PutMapping
  public String update() {
    userService.updateById(new com.vainglory.pojo.User());
    return "success";
  }

  @GetMapping
  public List<User> get() {
    StatusConditionHelper.setSkipStatusCondition(true);
    List<User> users = userService.list();
    return users;
  }
}
