package com.vainglory.system.controller;


import cn.dev33.satoken.stp.StpUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
  @RequestMapping("/login")
  public String login() {
    StpUtil.login(10001);
    String tokenValue = StpUtil.getTokenInfo().getTokenValue();
    System.out.println(tokenValue);
    return "login";
  }
}
