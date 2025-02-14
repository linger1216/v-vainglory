package com.vainglory.system.mapper;

import com.vainglory.system.domain.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author lid
* @description 针对表【t_dept】的数据库操作Mapper
* @createDate 2025-02-10 22:35:41
* @Entity com.vainglory.system.domain.Dept
*/
public interface DeptMapper extends BaseMapper<Dept> {
    public List<Dept> getDeptsByUserId(String userId);

}




