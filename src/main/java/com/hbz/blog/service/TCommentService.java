package com.hbz.blog.service;

import com.hbz.blog.entity.TComment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2020-06-11
 */
public interface TCommentService extends IService<TComment> {

    Map<String,Object> queryAllComment(long blogId, long page, long limit);
}
