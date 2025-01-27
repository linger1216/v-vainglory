package com.vainglory.controller;

import com.vainglory.pojo.dto.CreateUserReq;
import com.vainglory.pojo.User;
import com.vainglory.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
//    userService.save(user);
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
  public String get() {
    userService.getById(1);
    return "success";
  }
}
