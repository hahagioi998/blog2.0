package com.hbz.blog.controller;

import com.hbz.blog.entity.*;
import com.hbz.blog.service.*;
import com.hbz.blog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
@CrossOrigin
public class IndexController {
    @Autowired
    private TBlogService blogService;
    @Autowired
    private TTypeService typeService;
    @Autowired
    private TTagService tagService;
    @Autowired
    private SiteService siteService;
    @Autowired
    private SocialService socialService;
    // 获取博客
    @GetMapping("/index/{page}/{limit}")
    public R index(@PathVariable long page,@PathVariable long limit){
       Map<String,Object> map = blogService.index(page,limit);

       return R.ok().data(map);
    }
    // 获取分类
    @GetMapping("/getTag")
    public R getTag(){
        List<TType> TypeList = typeService.list(null);
        return R.ok().data("TagList",TypeList);
    }
    //获取站点信息
    @GetMapping("/site")
    public R getSite(){
        List<Site> list = siteService.list(null);
        return R.ok().data("data",list);
    }
    //获取站点社交信息
    @GetMapping("/social")
    public R getSocial(){
        List<Social> list = socialService.list(null);
        return R.ok().data("list",list);
    }

    //首页搜索功能
    @GetMapping("/search/{content}/{page}/{limit}")
    public R search(@PathVariable String content,@PathVariable long page,@PathVariable long limit){
        Map<String,Object> map = blogService.search(content,page,limit);
        return R.ok().data("blog",map);
    }

}
