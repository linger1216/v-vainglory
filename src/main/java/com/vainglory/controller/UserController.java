package com.vainglory.controller;

import com.vainglory.pojo.dto.CreateUserReq;
import com.vainglory.common.R;
import com.vainglory.pojo.User;
import com.vainglory.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private IUserService userService;

  @PostMapping
  public R<User> create(@RequestBody CreateUserReq req) {
//    User user = new User();
//    BeanUtils.copyProperties(req, user);
//    userService.save(user);
    return R.OK();
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
  public String get() {
    userService.getById(1);
    return "success";
  }
}
