package com.example.springb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("tags")
@Data
public class Tags {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer experience_id;
    private Integer project_id;
    private Integer education_id;
    private String tag;
}
