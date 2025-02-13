package com.vainglory.system.service;

import com.vainglory.system.domain.Dept;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author lid
* @description 针对表【t_dept】的数据库操作Service
* @createDate 2025-02-10 22:35:41
*/
public interface IDeptService extends IService<Dept> {
  List<Dept> getDeptsByUserId(String userId);
}
