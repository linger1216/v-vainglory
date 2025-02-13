package com.vainglory.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vainglory.system.domain.Post;
import com.vainglory.system.service.IPostService;
import com.vainglory.system.mapper.PostMapper;
import org.springframework.stereotype.Service;

/**
* @author lid
* @description 针对表【t_post】的数据库操作Service实现
* @createDate 2025-02-10 23:01:57
*/
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post>
    implements IPostService {

}




