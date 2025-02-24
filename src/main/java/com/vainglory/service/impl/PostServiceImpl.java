package com.vainglory.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vainglory.domain.Post;
import com.vainglory.mapper.PostMapper;
import com.vainglory.service.IPostService;
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




