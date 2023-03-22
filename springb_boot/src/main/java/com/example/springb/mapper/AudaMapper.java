package com.example.springb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springb.entity.Auda;
import com.example.springb.entity.Experiences;
//import com.example.springb.entity.User;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface AudaMapper extends BaseMapper<Auda> {
//
//    @Insert("insert into auda(user_id, auname) values(#{Id}, #{Auname})")
//    void insertaudata(Integer Id, String Auname);

    @Select("select DISTINCT auname from auda where user_id=#{userid}")
    List<Auda> selectByuserId(Integer userid);

//    UPDATE auda SET agree = '0' WHERE auname = 'admin';
    @Update("update auda set agree = #{agree} where auname = #{agrname} && user_id =#{user_id}")
//     void updateagree(Map<String, Object> map);
    void updateagree(String agree,String agrname,String user_id);

    @Select("SELECT id FROM `auda` WHERE user_id=#{user_id} && auname=#{auname}")
    Auda seleByIdName(String user_id,String auname);
}
