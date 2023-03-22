package com.example.springb.controller;

import com.example.springb.util.sendMessageUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.TimerTask;

@RestController
@RequestMapping("/mes")
public class SendSMSController {

    @GetMapping("/sendSMS")
    public void SendSMS(HttpServletRequest request, HttpServletResponse response)  {
        PrintWriter out = null;

        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String phoneNumber = request.getParameter("mobile");
        System.out.println(phoneNumber);

        // 发送短信
        sendMessageUtil sendMessageUtil = new sendMessageUtil();
        String result = sendMessageUtil.senSMSUtil(phoneNumber);

        if (result == null || !result.equals("OK")) {// 发送不成功
            System.out.println("失败");
        }

        // 获取验证码
        int code = sendMessageUtil.getCode();
        out.print(code);
        // 将数据存入SESSION
        request.getSession().setAttribute("checkCode", code);

        request.getSession().setAttribute("createTime", System.currentTimeMillis());
        // 将验证码生成时间存入SESSION，若超过五分钟则不通过校验
        // 将验证码生成时间存入SESSION，若超过五分钟则不通过校验
        final HttpSession session=request.getSession();
        try {
            // Timer 和 TimerTask都是java.util包下
            final Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    session.removeAttribute("checkCode");
                    System.err.println("checkCode删除成功");
                    timer.cancel();
                }
            }, 5 * 60 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 验证码检测
    @PostMapping("/checkCode")
    public void checkCode(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=utf8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String checkCode = request.getParameter("checkCode");
        String code = String.valueOf(session.getAttribute("checkCode"));
        if (checkCode.equals(code)) {
            //验证码使用成功后，从session删除
            request.getSession().removeAttribute("checkCode");
            out.print("验证码正确");
        } else {
            out.print("验证码错误");
        }
    }
}
