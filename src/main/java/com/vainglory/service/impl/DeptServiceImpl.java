package com.vainglory.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vainglory.domain.Dept;
import com.vainglory.mapper.DeptMapper;
import com.vainglory.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  private DeptMapper deptMapper;
  @Override
  public List<Dept> getDeptsByUserId(String userId) {
    return deptMapper.getDeptsByUserId(userId);
  }
}




