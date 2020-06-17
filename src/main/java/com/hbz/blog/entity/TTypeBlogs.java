package com.hbz.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author testjava
 * @since 2020-06-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TTypeBlogs对象", description="")
public class TTypeBlogs implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long typeId;

    @TableId(value = "blogs_id", type = IdType.ID_WORKER_STR)
    private Long blogsId;


}
