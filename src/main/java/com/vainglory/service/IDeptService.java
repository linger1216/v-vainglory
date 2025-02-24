package com.vainglory.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vainglory.domain.Dept;

import java.util.List;

/**
* @author lid
* @description 针对表【t_dept】的数据库操作Service
* @createDate 2025-02-10 22:35:41
*/
public interface IDeptService extends IService<Dept> {
  List<Dept> getDeptsByUserId(String userId);
}
