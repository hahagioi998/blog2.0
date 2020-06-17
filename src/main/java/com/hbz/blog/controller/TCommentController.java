package com.hbz.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbz.blog.entity.TBlog;
import com.hbz.blog.entity.TComment;
import com.hbz.blog.service.TCommentService;
import com.hbz.blog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hbz
 * @since 2020-06-15
 */
@RestController
@RequestMapping("/comment")
@CrossOrigin
public class TCommentController {

    @Autowired
    private TCommentService commentService;

    @GetMapping("/{blogId}/{page}/{limit}")
    public R getCommentById(@PathVariable long blogId,@PathVariable long page,@PathVariable long limit){

        Map<String, Object> map = commentService.queryAllComment(blogId, page, limit);

        return R.ok().data(map);
    }
    //
    @PostMapping("/reply/{commentId}")
    public R reply(@PathVariable long commentId,@RequestBody TComment comment){
        if (commentId!=0){
            comment.setParentCommentId(commentId);
        }
        if (comment.getAvatar()==null|| comment.getAvatar().equals("")){
            comment.setAvatar("https://hbz-edu-file.oss-cn-beijing.aliyuncs.com/%E9%BB%98%E8%AE%A4%E5%A4%B4%E5%83%8F.jpg");
        }
        comment.setCreateTime(new Date());
        commentService.save(comment);
        return R.ok();
    }
}

