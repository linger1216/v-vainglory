package com.vainglory.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vainglory.domain.Role;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {
  List<Role> getRolesByUserId(String userId);
}




