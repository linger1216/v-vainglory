package com.vainglory.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vainglory.system.domain.Role;
import com.vainglory.system.service.IRoleService;
import com.vainglory.system.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author lid
* @description 针对表【t_role】的数据库操作Service实现
* @createDate 2025-02-10 23:01:57
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements IRoleService {

  @Autowired
  private RoleMapper roleMapper;



  @Override
  public List<Role> getRolesByUserId(String userId) {
    // 调用mapper接口的getRolesByUserId方法
    List<Role> roles = roleMapper.getRolesByUserId(userId);
    return roles;
  }
}




