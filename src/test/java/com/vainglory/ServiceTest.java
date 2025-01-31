package com.vainglory;

import com.vainglory.mapper.UserMapper;
import com.vainglory.pojo.User;
import com.vainglory.service.impl.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceTest {

  @Autowired
  private UserMapper userMapper;
  @Test
  public void UserTest() {
    User user = new User();
    user.setAvatar("avatar");
    user.setEmail("lid.guan@gmail.com");
    user.setNickname("lid_guan");
    user.setPhone("13816532331");
    user.setUsername("lid_guan");
    user.setPassword("123456789");
    user.setSalt("salt");
//    UserService userService = new UserService();
    userMapper.insert(user);
  }
}
