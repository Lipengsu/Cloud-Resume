package com.example.springb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("auda")
@Data
public class Auda {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer user_id;
    private String auname;
    private String agree;
}
