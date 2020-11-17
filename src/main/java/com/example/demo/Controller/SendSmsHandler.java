package com.example.demo.Controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.example.demo.Entity.HandlerConfig;
import com.example.demo.Service.BookService;
import com.example.demo.utils.HttpUtils;
import com.example.demo.utils.Md5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import result.CommonResult;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Api(tags = "必达消息", description = "message")
@RestController
@RequestMapping("/test")
@Log4j2
public class SendSmsHandler {
    @Autowired BookService bookService;


    private HandlerConfig handlerConfig;

    public void SendSmsHandler(HandlerConfig handlerConfig) {
        this.handlerConfig = handlerConfig;
    }


    @ApiOperation("状态回调")
    @PostMapping("/handler")
    @ResponseBody

    public CommonResult SendSmsHandler() {


        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String nowTime = sdf.format(date);


        String result = Md5Util.StringInMd5("aaf98f894f402f15014f47296f9305b6" + "4c3bf9a9f1114bd2a85d1de6552a3143" + nowTime);
        String r = result.toUpperCase();
        System.out.println(r);
        try {

            String a = HttpUtils.sendSSLPost(
                    "https://app.cloopen.com:8883/2013-12-26/Accounts/aaf98f894f402f15014f47296f9305b6/SMS/GetArrived?sig="+r,
                    "{\"appId\":\"8aaf0708754a3ef2017572b5ce560d55\"}"
            );
            System.out.println(a);
            JSONObject json= JSONObject.parseObject(a);
            JSONArray ja =json.getJSONArray("reports");
            List<JSONObject> list=new ArrayList<>();
            for (Object obj:ja) {
                String re=obj.toString();
                JSONObject joni= JSONObject.parseObject(re);
                System.out.println(joni);
                joni.put("fromNum",bookService.selectByNum(joni.getString("fromNum")));
                list.add(joni);
            }
            return  CommonResult.success(list);

        } catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed();
        }


        }



    }

