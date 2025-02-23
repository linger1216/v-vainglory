package com.vainglory.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vainglory.system.domain.User;
import com.vainglory.system.mapper.UserMapper;
import com.vainglory.system.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
