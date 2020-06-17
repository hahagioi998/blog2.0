package com.hbz.blog.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BlogAndTag {
    private Integer id;
    private Date createTime;
    private String description;
    private String firstPicture;
    private String flag;
    private String title;
    private Long tId;
    private String tName;
}
