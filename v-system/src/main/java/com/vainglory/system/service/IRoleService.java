package com.vainglory.system.service;

import com.vainglory.system.domain.Api;
import com.vainglory.system.domain.Menu;
import com.vainglory.system.domain.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author lid
* @description 针对表【t_role】的数据库操作Service
* @createDate 2025-02-10 23:01:57
*/
public interface IRoleService extends IService<Role> {
  List<Role> getRolesByUserId(String userId);
}
