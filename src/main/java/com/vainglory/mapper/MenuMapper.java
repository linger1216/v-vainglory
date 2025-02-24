package com.vainglory.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vainglory.domain.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {
  List<Menu> getMenusByRoleId(String roleId);
  List<Menu> getMenusByUserId(String userId);
}




