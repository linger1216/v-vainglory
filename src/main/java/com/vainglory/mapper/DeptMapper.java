package com.vainglory.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vainglory.domain.Dept;

import java.util.List;


public interface DeptMapper extends BaseMapper<Dept> {
    public List<Dept> getDeptsByUserId(String userId);

}




