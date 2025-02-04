package com.vainglory.service.impl;

import com.vainglory.pojo.Post;
import com.vainglory.mapper.PostMapper;
import com.vainglory.service.IPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lid
 * @since 2025-02-04
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

}
