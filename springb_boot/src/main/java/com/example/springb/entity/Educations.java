package com.example.springb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("educations")
@Data
public class Educations {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer user_id;
    private String from;
    private String to;
    private String school;
    private String degree;
    private String description;
    private String tags;
}
