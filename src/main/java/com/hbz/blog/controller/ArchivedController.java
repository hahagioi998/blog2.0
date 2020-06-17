package com.hbz.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hbz.blog.entity.TBlog;
import com.hbz.blog.entity.vo.Archived;
import com.hbz.blog.service.TBlogService;
import com.hbz.blog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/archived")
@CrossOrigin
public class ArchivedController {
    @Autowired
    private TBlogService blogService;
    @PostMapping
    public R archived(@RequestBody Archived archived){
        QueryWrapper<TBlog> wrapper = new QueryWrapper<>();
        String sort = archived.getSort();//1,升序 2,降序
        String begin = archived.getBegin();
        String end = archived.getEnd();
        if (!StringUtils.isEmpty(sort)) {
            if (sort.equals("1")) {
                wrapper.orderByAsc("update_time"); //升序asc为从低到高
            }else {
                wrapper.orderByDesc("update_time");//降序desc为从高到低
            }
        }else {
            wrapper.orderByDesc("update_time");//降序desc为从高到低
        }
        if (!StringUtils.isEmpty(begin)) {
            wrapper.ge("update_time", begin);//大于
        }
        if (!StringUtils.isEmpty(end)) {
            wrapper.le("update_time", end);//小于
        }
        List<TBlog> list = blogService.list(wrapper);
        int count = blogService.count(wrapper);
        return R.ok().data("count",count).data("list",list);
    }
}
