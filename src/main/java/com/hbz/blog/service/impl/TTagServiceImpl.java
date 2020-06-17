package com.hbz.blog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hbz.blog.entity.BlogAndTag;
import com.hbz.blog.entity.BlogTagCount;
import com.hbz.blog.entity.TTag;
import com.hbz.blog.mapper.TTagMapper;
import com.hbz.blog.service.TTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-06-11
 */
@Service
public class TTagServiceImpl extends ServiceImpl<TTagMapper, TTag> implements TTagService {


    @Override
    public Page<BlogAndTag> findBlogTagByPage(String tagId, int page, int limit) {
        PageHelper.startPage(page, limit);
        return baseMapper.findBlogTagByPage(tagId);
    }

    @Override
    public List<BlogTagCount> countTagBlog() {
        return baseMapper.countTagBlog();
    }
}
