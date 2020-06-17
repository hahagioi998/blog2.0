package com.hbz.blog.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Archived {
    @ApiModelProperty(value = "排序", example = "1,升序 2,降序")
    private String sort;
    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String begin;//注意，这里使用的是String类型，前端传过来的数据无需进行类型转换
    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private String end;
}
