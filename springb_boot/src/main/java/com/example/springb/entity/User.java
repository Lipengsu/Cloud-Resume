package com.example.springb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@TableName("user")
@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String fullname;
    private String job;
    private String phone;
    private String email;
    private String links;
    private String socialnetwork;
    private String resume;
    private String certificate;
    private Integer role;
//    private Integer auda;
    @TableField(exist = false)
    private List<Experiences> experiencesList;
    @TableField(exist = false)
    private List<Experiences> projectsList;
    @TableField(exist = false)
    private List<Experiences> educationsList;
    @TableField(exist = false)
    private List<Experiences> audaList;
}
