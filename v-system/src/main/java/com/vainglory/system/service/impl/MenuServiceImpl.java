package com.vainglory.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vainglory.system.domain.Menu;
import com.vainglory.system.service.IMenuService;
import com.vainglory.system.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author lid
* @description 针对表【t_menu】的数据库操作Service实现
* @createDate 2025-02-10 23:01:57
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements IMenuService {


  @Autowired
  private MenuMapper menuMapper;

  @Override
  public List<Menu> getMenusByRoleId(String roleId) {
    return menuMapper.getMenusByRoleId(roleId);
  }
}




