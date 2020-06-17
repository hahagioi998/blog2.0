package com.hbz.blog.service;

import com.hbz.blog.entity.TType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2020-06-11
 */
public interface TTypeService extends IService<TType> {

    Map<String, Object> getTypeForBlog(long typeId,long page,long limit);
}
