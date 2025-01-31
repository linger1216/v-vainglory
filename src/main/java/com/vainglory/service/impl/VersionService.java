package com.vainglory.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vainglory.mapper.VersionMapper;
import com.vainglory.pojo.Version;
import com.vainglory.service.IVersionService;
import org.springframework.stereotype.Service;

@Service
public class VersionService extends ServiceImpl<VersionMapper, Version> implements IVersionService {
}
