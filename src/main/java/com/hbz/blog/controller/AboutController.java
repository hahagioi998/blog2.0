package com.hbz.blog.controller;


import com.hbz.blog.entity.About;
import com.hbz.blog.entity.Aboutme;
import com.hbz.blog.service.AboutService;
import com.hbz.blog.service.AboutmeService;
import com.hbz.blog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hbz
 * @since 2020-06-14
 */
@RestController
@RequestMapping("/about")
@CrossOrigin
public class AboutController {
    @Autowired
    private AboutService aboutService;

    @Autowired
    private AboutmeService aboutmeService;
    @PostMapping
    public R AboutMe(@RequestBody About about){
        boolean save = aboutService.save(about);
        if (save){
            return R.ok().data("data","你的留言我已经收到，我会仔细阅读后回复你的！");
        }else {
            return R.error().data("data","OMG.留言失败，请稍后再试！");
        }
    }
    @GetMapping("/resume")
    public R getResume(){
        Aboutme aboutme = aboutmeService.getById(1);
        return R.ok().data("resume",aboutme);
    }
}

