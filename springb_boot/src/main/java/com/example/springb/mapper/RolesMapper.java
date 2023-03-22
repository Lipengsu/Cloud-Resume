package com.example.springb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springb.entity.Experiences;
import com.example.springb.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolesMapper extends BaseMapper<User> {
    List<User> selectbyrole(@Param("role") Integer role);
}
