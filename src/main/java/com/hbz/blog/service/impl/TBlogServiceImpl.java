package com.hbz.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbz.blog.entity.TBlog;
import com.hbz.blog.entity.TTag;
import com.hbz.blog.entity.TType;
import com.hbz.blog.mapper.TBlogMapper;
import com.hbz.blog.service.TBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbz.blog.service.TTagService;
import com.hbz.blog.service.TTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-06-11
 */
@Service
public class TBlogServiceImpl extends ServiceImpl<TBlogMapper, TBlog> implements TBlogService {
    @Autowired
    private TTagService tagService;
    @Autowired
    private TTypeService typeService;
    @Override
    public Map<String, Object> index(long page, long limit) {

        //创建page对象
        Page<TBlog> BlogPage = new Page<>(page,limit);
        //构建条件
        QueryWrapper<TBlog> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time");
        baseMapper.selectPage(BlogPage, wrapper);
        long total = BlogPage.getTotal(); //总记录数
        List<TBlog> records = BlogPage.getRecords(); //集合
        boolean hasNext = BlogPage.hasNext();
//        // 博客分类
//        QueryWrapper<TType> TypeWrapper = new QueryWrapper<>();
//        TypeWrapper.last(" limit 6 ");
//        List<TType> typeList = typeService.list(TypeWrapper);
//
//        // 博客标签
//        QueryWrapper<TTag> TagWrapper = new QueryWrapper<>();
//        TagWrapper.last(" limit 10 ");
//        List<TTag> tagList = tagService.list(TagWrapper);

        // 最新博客推荐
        QueryWrapper<TBlog> recommendWrapper = new QueryWrapper<>();
        recommendWrapper.ne(" recommend","b'1'");
        recommendWrapper.orderByDesc("update_time");
        recommendWrapper.last(" limit 3 ");
        List<TBlog> recommendList = baseMapper.selectList(recommendWrapper);

        Map<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("records",records);
        map.put("hasNext",hasNext);
        map.put("recommendList",recommendList);
        return map;
    }

    @Override
    public Map<String, Object> search(String content, long page, long limit) {
        //创建page对象
        Page<TBlog> BlogPage = new Page<>(page,limit);
        //构建条件
        QueryWrapper<TBlog> wrapper = new QueryWrapper<>();
        wrapper.like("title",content);
        wrapper.orderByDesc("create_time");
        baseMapper.selectPage(BlogPage, wrapper);
        long total = BlogPage.getTotal(); //总记录数
        List<TBlog> records = BlogPage.getRecords(); //集合
        boolean hasNext = BlogPage.hasNext();
        Map<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("records",records);
        map.put("hasNext",hasNext);
        return map;
    }

    @Override
    public void updateViews(long id) {
        baseMapper.updateViews(id);
    }
}
