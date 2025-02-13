package com.vainglory.system.mapper;

import com.vainglory.system.domain.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author lid
* @description 针对表【t_role】的数据库操作Mapper
* @createDate 2025-02-10 23:01:57
* @Entity com.vainglory.system.domain.Role
*/
public interface RoleMapper extends BaseMapper<Role> {
  List<Role> getRolesByUserId(String userId);
}




