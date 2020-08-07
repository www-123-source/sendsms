package com.example.demo.Controller;

import com.example.demo.Entity.MessageConfig;
import com.example.demo.sms;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Api(tags ="必达消息",description = "message")
@RestController
@RequestMapping("/test")

public class SendSmsController {
    @ApiOperation("发送短信接口")
    @PostMapping("/send")
    @ResponseBody


    String SendSms(@RequestBody(required = false) MessageConfig messageConfig) {

            Thread thread = new Thread(new sms(messageConfig));
            thread.run();
            System.out.println(messageConfig);
            return "发送成功";



    }
}



//    @ApiOperation("发送短信接口")
//    @PostMapping("/send")
//    @ResponseBody
//    String SendSms() {
//        try {
//        AliyunSendSms aliyunSendSms = new AliyunSendSms();
//        aliyunSendSms.run();
//        return "发送成功";}
//
//        catch(Exception e){
//            return "发送失败";
//        }
//    }


