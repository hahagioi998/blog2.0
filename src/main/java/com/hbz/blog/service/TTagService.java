package com.hbz.blog.service;

import com.github.pagehelper.Page;
import com.hbz.blog.entity.BlogAndTag;
import com.hbz.blog.entity.BlogTagCount;
import com.hbz.blog.entity.TTag;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2020-06-11
 */
public interface TTagService extends IService<TTag> {
    /**
     * 根据标签id进行博客的分页查询
     * @param tagId 标签id
     * @param page 当前页
     * @param limit 每页查询数
     * @return
     */
    Page<BlogAndTag> findBlogTagByPage(String tagId,int page,int limit);

    List<BlogTagCount> countTagBlog();
}
