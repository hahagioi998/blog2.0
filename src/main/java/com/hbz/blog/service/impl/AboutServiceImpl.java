package com.hbz.blog.service.impl;

import com.hbz.blog.entity.About;
import com.hbz.blog.mapper.AboutMapper;
import com.hbz.blog.service.AboutService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hbz
 * @since 2020-06-14
 */
@Service
public class AboutServiceImpl extends ServiceImpl<AboutMapper, About> implements AboutService {

}
