package com.hbz.blog.service;

import com.hbz.blog.entity.TBlog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2020-06-11
 */
public interface TBlogService extends IService<TBlog> {

    Map<String, Object> index(long page, long limit);

    Map<String, Object> search(String content, long page, long limit);

    void updateViews(long id);
}
