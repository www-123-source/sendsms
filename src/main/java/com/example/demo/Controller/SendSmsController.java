package com.example.demo.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.Entity.MessageConfig;
import com.example.demo.Entity.MyMessageConfig;
import com.example.demo.Service.BookService;
import com.example.demo.sms;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import result.CommonResult;
import java.util.*;

@Api(tags ="必达消息",description = "message")
@RestController
@RequestMapping("/test")
@Log4j2
@Component

public class SendSmsController {

    @RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
    @RabbitHandler
    public void process(MyMessageConfig testMessage) {
        JSONObject json = JSONObject.parseObject(String.valueOf(testMessage));
        JSONArray ja = json.getJSONArray("replaceData");
        List<JSONObject> list = new ArrayList<>();
        for (Object obj : ja) {
            String re = obj.toString();
            JSONObject joni = JSONObject.parseObject(re);
            System.out.println(joni);
            list.add(joni);
        }
    }


    @Autowired
    BookService bookService;
    @ApiOperation("发送短信接口")
    @PostMapping("/send")
    @ResponseBody
    CommonResult SendSms(@RequestBody(required = false) MessageConfig messageConfig) {
        sms s = new sms(messageConfig);
        Thread thread = new Thread(s);
        thread.run();
        s.getResult();
        System.out.println(messageConfig);
        return CommonResult.success(s.getResult());

    }
}


//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//        String nowTime = sdf.format(date);
//
//
//        String result = Md5Util.StringInMd5("aaf98f894f402f15014f47296f9305b6" + "4c3bf9a9f1114bd2a85d1de6552a3143" + nowTime);
//        String r = result.toUpperCase();
//        System.out.println(r);
//        try {
//
//            String a = HttpUtils.sendSSLPost(
//                    "https://app.cloopen.com:8883/2013-12-26/Accounts/aaf98f894f402f15014f47296f9305b6/SMS/GetArrived?sig="+r,
//                    "{\"appId\":\"8a48b5514f49079e014f4ae30b730723\"}"
//            );
//            System.out.println(a);
//            JSONObject json= JSONObject.parseObject(a);
//            JSONArray ja =json.getJSONArray("reports");
//            List<JSONObject> list=new ArrayList<>();
//            for (Object obj:ja) {
//                String re=obj.toString();
//                JSONObject joni= JSONObject.parseObject(re);
//                System.out.println(joni);
//                joni.put("fromNum",bookService.selectByNum(joni.getString("fromNum")));
//                list.add(joni);
//            }
//            return  CommonResult.success(list);
//
//        } catch (Exception e) {
//            log.error(e.getMessage());
//            return CommonResult.failed();
//        }
//
//
//    }
//







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


