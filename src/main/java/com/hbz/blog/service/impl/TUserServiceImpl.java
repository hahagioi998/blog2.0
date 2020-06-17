package com.hbz.blog.service.impl;

import com.hbz.blog.entity.TUser;
import com.hbz.blog.mapper.TUserMapper;
import com.hbz.blog.service.TUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-06-11
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

}
