package com.vainglory.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vainglory.domain.Role;

import java.util.List;

/**
* @author lid
* @description 针对表【t_role】的数据库操作Service
* @createDate 2025-02-10 23:01:57
*/
public interface IRoleService extends IService<Role> {
  List<Role> getRolesByUserId(String userId);
}
