package com.hbz.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbz.blog.entity.TComment;
import com.hbz.blog.mapper.TCommentMapper;
import com.hbz.blog.service.TCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-06-11
 */
@Service
public class TCommentServiceImpl extends ServiceImpl<TCommentMapper, TComment> implements TCommentService {

    @Override
    public Map<String,Object>  queryAllComment(long blogId, long page, long limit) {
        //查询博客下的所有评论
        //创建page对象
        Page<TComment> commentPage = new Page<>(page,limit);
        //构建条件
        QueryWrapper<TComment> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time");
        wrapper.eq("blog_id",blogId);
        IPage<TComment> commentIPage = baseMapper.selectPage(commentPage, wrapper);
        //1. 查询博客下的所有评论
        List<TComment> list = commentIPage.getRecords(); //总记录集合
        long total = commentIPage.getTotal();//总数
        long pages = commentIPage.getPages();//页数

        //2 把查询所有菜单list集合按照要求进行封装
        List<TComment> resultList = bulidPermission(list);
        HashMap<String, Object> map = new HashMap<>();
        map.put("list",resultList);
        map.put("total",total);
        map.put("pages",pages);
        return map;
    }

    private static List<TComment> bulidPermission(List<TComment> list) {
        //创建list集合，用于数据最终封装
        List<TComment> finalNode = new ArrayList<>();
        //把所有菜单list集合遍历，得到顶层评论 设置level是1
        for(TComment comment : list) {
            //得到顶层评论
            Long parentCommentId = comment.getParentCommentId();
            if(StringUtils.isEmpty(parentCommentId)) {
                //设置顶层菜单的level是1
                comment.setLevel(1);
                //根据顶层菜单，向里面进行查询子菜单，封装到finalNode里面
                finalNode.add(selectChildren(comment,list));
            }
        }


        return finalNode;
    }

    private static TComment selectChildren(TComment comment, List<TComment> list) {
        //1 因为向一层评论里面放二层评论，二层里面还要放三层，把对象初始化
        comment.setChildren(new ArrayList<TComment>());

        //2 遍历所有评论list集合，进行判断比较，比较id和pid值是否相同
        for(TComment it : list) {
            //判断 id和pid值是否相同
            if(comment.getId().equals(it.getParentCommentId())) {
                //把父评论的level值+1
                int level = comment.getLevel()+1;
                it.setLevel(level);
                //如果children为空，进行初始化操作
                if(comment.getChildren() == null) {
                    comment.setChildren(new ArrayList<TComment>());
                }
                //把查询出来的子评论放到评论单里面
                comment.getChildren().add(selectChildren(it,list));
            }
        }
        return comment;
    }
}
