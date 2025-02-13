package com.vainglory.system.mapper;

import com.vainglory.system.domain.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author lid
* @description 针对表【t_menu】的数据库操作Mapper
* @createDate 2025-02-10 23:01:57
* @Entity com.vainglory.system.domain.Menu
*/
public interface MenuMapper extends BaseMapper<Menu> {
  List<Menu> getMenusByRoleId(String roleId);
}




