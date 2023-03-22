package com.example.springb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springb.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    // 一对多查询
    User selectbyid(@Param("id") Integer id);

//
//    @Select("select count(id) count, address from user GROUP BY address")
//    List<UserAddressDto> countAddress();
//
//    // 查询用户名
//    @Select("select password from user where username=#{username}")
//    User selectByName(String username);
//
//    @Update("update user set password = #{newPass} where id = #{userId}")
//    int updatePass(Map<String, Object> map);
}
