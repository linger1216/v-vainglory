package com.vainglory.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vainglory.system.domain.Dept;
import com.vainglory.system.service.IDeptService;
import com.vainglory.system.mapper.DeptMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author lid
* @description 针对表【t_dept】的数据库操作Service实现
* @createDate 2025-02-10 22:35:41
*/
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept>
    implements IDeptService {

  @Override
  public List<Dept> getDeptsByUserId(String userId) {
    return null;
  }
}




