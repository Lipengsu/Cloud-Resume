package com.example.springb.controller;

import com.example.springb.common.Result;
import com.example.springb.entity.User;
import com.example.springb.mapper.RolesMapper;
import com.example.springb.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Resource
    RolesMapper rolesMapper;
    @GetMapping
    public Result<?> findrole(@RequestParam Integer role){
        List<User> user = rolesMapper.selectbyrole(role);
        return Result.success(user);
    }
}
