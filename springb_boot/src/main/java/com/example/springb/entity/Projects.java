package com.example.springb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@TableName("projects")
@Data
public class Projects {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer user_id;
    private String name;
    private String link;
    private String from;
    private String to;
    private String description;
    private String tags;
}
