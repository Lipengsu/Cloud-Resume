package com.example.springb.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.springb.common.Result;
import com.example.springb.entity.User;
import com.example.springb.mapper.AudaMapper;
import com.example.springb.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.NodeList;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

@RestController
@RequestMapping("/user")
//@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

    @Resource
    UserMapper userMapper;

    @PostMapping("/login")
    public Result<?> login(@RequestBody User user){
        User res = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername()).eq(User::getPassword, user.getPassword()));
        if(res == null){
            return Result.error("-1","用户名或密码错误！");
        }else {
            return Result.success(res);
        }
    }
    @PostMapping("/register")
    public Result<?> register(@RequestBody User user){
        User res = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername()));
        if(res != null){
            return Result.error("-1","用户名重复");
        }
        userMapper.insert(user);
        return Result.success();
    }

    @PostMapping
    public Result<?> save(@RequestBody User user) {
        userMapper.insert(user);
        return Result.success();
    }
    @GetMapping
//    @CrossOrigin(origins = "http://localhost:8080")
    public Result<?> find(@RequestParam Integer id) {
//        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery().orderByAsc(User::getId);
//        if (StrUtil.isNotBlank(id.toString())) {
//            wrapper.like(User::getFullname, id);
//        }
        User user = userMapper.selectbyid(id);
//        String links = user.getLinks();
//        NodeList ll = split(links);
//        user.setLinks(String.valueOf(ll));
        return Result.success(user);
    }
}
