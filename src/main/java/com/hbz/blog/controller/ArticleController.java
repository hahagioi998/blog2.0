package com.hbz.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hbz.blog.entity.TBlog;
import com.hbz.blog.entity.TType;
import com.hbz.blog.entity.TUser;
import com.hbz.blog.service.TBlogService;
import com.hbz.blog.service.TTypeService;
import com.hbz.blog.service.TUserService;
import com.hbz.blog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {
    @Autowired
    private TBlogService blogService;
    @Autowired
    private TUserService userService;
    @Autowired
    private TTypeService typeService;
    @GetMapping("{id}")
    public R getBlogById(@PathVariable long id){
        blogService.updateViews(id);
        TBlog blog = blogService.getById(id);
        TUser user = userService.getById(blog.getUserId());
        TType type = typeService.getById(blog.getTypeId());
        return R.ok().data("blog",blog).data("username",user.getNickname()).data("type",type);
    }
}
