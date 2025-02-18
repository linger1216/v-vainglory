package com.vainglory.system.service.impl;

import cn.dev33.satoken.secure.BCrypt;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vainglory.system.domain.User;
import com.vainglory.system.domain.dto.UserResp;
import com.vainglory.system.mapper.UserMapper;
import com.vainglory.system.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

//  @Override
//  public boolean save(User user) {
//    String salt = BCrypt.gensalt();
//    // 加盐
//    user.setSalt(salt);
//
//    String password = user.getPassword();
//
//    // 对密码进行加密
//    String encryptedPassword = encryptPassword(password, salt);
//    user.setPassword(encryptedPassword);
//
//    // 调用父类的 save 方法
//    return super.save(user);
//  }
//
//  private String encryptPassword(String password, String salt) {
//    return BCrypt.hashpw(password, BCrypt.gensalt());
//  }
}
