package com.hbz.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hbz.blog.entity.TBlog;
import com.hbz.blog.service.TTypeService;
import com.hbz.blog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class TypeController {
    @Autowired
    private TTypeService typeService;
    @GetMapping("{typeId}/{page}/{limit}")
    public R TypeBlog(@PathVariable long typeId,@PathVariable long page,@PathVariable long limit){
        Map<String,Object> map =typeService.getTypeForBlog(typeId,page,limit);
        return R.ok().data(map);
    }
}
