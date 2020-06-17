package com.hbz.blog.mapper;

import com.github.pagehelper.Page;
import com.hbz.blog.entity.BlogAndTag;
import com.hbz.blog.entity.BlogTagCount;
import com.hbz.blog.entity.TTag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2020-06-11
 */
public interface TTagMapper extends BaseMapper<TTag> {
    /**
     * 分页查询数据
     * @return
     */
    Page<BlogAndTag> findBlogTagByPage(String tagId);

    List<BlogTagCount> countTagBlog();
}
