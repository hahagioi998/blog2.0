package com.hbz.blog.controller;


import com.github.pagehelper.Page;
import com.hbz.blog.entity.BlogAndTag;
import com.hbz.blog.entity.BlogTagCount;
import com.hbz.blog.entity.Social;
import com.hbz.blog.service.TTagService;
import com.hbz.blog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-06-11
 */
@RestController
@RequestMapping("/tag")
@CrossOrigin
public class TagController {
    @Autowired
    private TTagService tagService;
    @GetMapping("/{tagId}/{page}/{limit}")
    public R getBlogById(@PathVariable String tagId,@PathVariable int page,@PathVariable int limit){
        if (tagId.equals("0")){
            List<BlogTagCount> countList = tagService.countTagBlog();
            Long id = countList.get(0).getId();
            tagId = id+"";
        }
        Page<BlogAndTag> list = tagService.findBlogTagByPage(tagId,page,limit);
        int pageNum = list.getPageNum();//当前页
        int pageSize = list.getPageSize(); //每页的数量
        long total = list.getTotal();//总记录数
        int pages = list.getPages();//总页数
        Map<String,Object> map = new HashMap<>();
        map.put("list",list);
        map.put("pageNum",pageNum);
        map.put("pageSize",pageSize);
        map.put("total",total);
        map.put("pages",pages);
        return R.ok().data("blogAndTag",map);
    }
    @GetMapping("/top")
    public R countTagBlog(){
        List<BlogTagCount> countList = tagService.countTagBlog();
        return R.ok().data("countList",countList);
    }
}

