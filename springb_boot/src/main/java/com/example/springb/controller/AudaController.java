package com.example.springb.controller;


import com.example.springb.common.Result;
import com.example.springb.entity.Auda;
import com.example.springb.mapper.AudaMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auda")

public class AudaController {
    @Resource
    AudaMapper audaMapper;

    @PostMapping
    public Result<?> audainsert(@RequestBody Auda auda) {
//        Auda res = audaMapper.selectOne(Wrappers.<Auda>lambdaQuery().eq(Auda::getAuname, auda.getAuname()));
        Auda res = audaMapper.seleByIdName(auda.getUser_id().toString(), auda.getAuname());
        if (res != null) {
            return Result.error("-1", "已经发送请求，请耐心等待");
        }
        audaMapper.insert(auda);
        return Result.success();
    }

    @GetMapping
    public Result<?> findmessage(@RequestParam Integer id) {
        List<Auda> audas = audaMapper.selectByuserId(id);
        return Result.success(audas);
    }

    //    @GetMapping()
//    public Result<?> findmessage(@RequestParam(defaultValue = "") Integer userid){
//        User user = audaMapper.selectByuserId(userid);
//        return Result.success(user);
//    }
//    @PutMapping("/agr")
//    public Result<?> audaupdata(@RequestBody Map<String, Object> map) {
//        map.put("agree", map.get("agree").toString());
//        audaMapper.updateagree(map);
//        return Result.success();
//    }
    @PutMapping("/agr")
    public Result<?> audaupdata(@RequestBody Auda auda) {
        audaMapper.updateagree(auda.getAgree(),auda.getAuname(),auda.getUser_id().toString());
        return Result.success();
    }
//    @PostMapping("/audaagr")
//    public Result<?> audaupdata(@RequestParam Auda auda) {
//        audaMapper.updateagree(auda.getAuname(), auda.getAgree());
//        return Result.success();
//    }
}
