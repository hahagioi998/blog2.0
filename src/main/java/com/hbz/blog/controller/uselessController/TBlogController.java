package com.hbz.blog.controller.uselessController;


import com.hbz.blog.service.TBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-06-11
 */
@RestController
@RequestMapping("/blog")
public class TBlogController {
    @Autowired
    private TBlogService blogService;


}

