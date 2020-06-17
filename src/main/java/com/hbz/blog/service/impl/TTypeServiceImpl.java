package com.hbz.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbz.blog.entity.TBlog;
import com.hbz.blog.entity.TType;
import com.hbz.blog.mapper.TTypeMapper;
import com.hbz.blog.service.TBlogService;
import com.hbz.blog.service.TTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class TTypeServiceImpl extends ServiceImpl<TTypeMapper, TType> implements TTypeService {
    @Autowired
    private TBlogService blogService;

    @Override
    public Map<String, Object> getTypeForBlog(long typeId, long page, long limit) {
        TType type = baseMapper.selectById(typeId);//博客类型
        //创建page对象
        Page<TBlog> BlogPage = new Page<>(page,limit);
        //构建条件
        QueryWrapper<TBlog> wrapper = new QueryWrapper<>();
        wrapper.eq("type_id",typeId);
        wrapper.orderByDesc("create_time");
        blogService.page(BlogPage,wrapper);
        long total = BlogPage.getTotal(); //总记录数
        List<TBlog> records = BlogPage.getRecords(); //集合
        boolean hasNext = BlogPage.hasNext(); //有没有下一页
        Map<String, Object> map = new HashMap<>();
        map.put("type",type);
        map.put("total",total);
        map.put("records",records);
        map.put("hasNext",hasNext);
        return map;
    }
}
