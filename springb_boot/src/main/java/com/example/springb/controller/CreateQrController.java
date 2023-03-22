package com.example.springb.controller;

//controller层
import com.example.springb.util.QrCodeUtils;
//import com.xdhyy.resume.util.QrCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;


@Controller
@RequestMapping("/createQrCode")
public class CreateQrController {
    //    @RequestMapping("/createQrCode")
//    public void createQrCode(HttpServletRequest request, HttpServletResponse response) {
//        StringBuffer url = request.getRequestURL();
//        try {
//            OutputStream os = response.getOutputStream();
//            //从配置文件读取需要生成二维码的连接
////            String requestUrl = GraphUtils.getProperties("requestUrl");
//            //requestUrl:需要生成二维码的连接，logoPath：内嵌图片的路径，os：响应输出流，needCompress:是否压缩内嵌的图片
//            QrCodeUtils.encode("http://www.baidu.com", "/static/images/1.png", os, true);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    @GetMapping()
    public void createQrCode(HttpServletResponse response) throws Exception {

        OutputStream os = response.getOutputStream();
        QrCodeUtils.encode("http://www.baidu.com", "/static/img/18813743464083358.jpg", os,true);
    }
}
