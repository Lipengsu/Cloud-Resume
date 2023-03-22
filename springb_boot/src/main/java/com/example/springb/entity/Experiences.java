package com.example.springb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sun.org.apache.xerces.internal.xs.StringList;
import lombok.Data;

import java.util.List;

@TableName("experiences")
@Data
public class Experiences {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer user_id;
    private String role;
    private String company;
    private String fromto;
    private String isCurrentJob;
    private String description;
    @TableField(exist = false)
    private List<Tags> tagsList;
}
