//package com.example.demo.Controller;
//
//import com.example.demo.CallPhone;
//import com.example.demo.Entity.MessageConfig;
//import com.example.demo.Entity.PhoneConfig;
//import com.example.demo.Service.BookService;
//import com.example.demo.sms;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.*;
//import result.CommonResult;
//
//@Api(tags ="必达消息",description = "message")
//@RestController
//@RequestMapping("/test")
//@Log4j2
//@Component
//public class CallPhoneController {
//    @Autowired
//    BookService bookService;
//    @ApiOperation("打电话")
//    @PostMapping("/CallPhone")
//    @ResponseBody
//    CommonResult CallPhone(PhoneConfig phoneConfig){
////        System.setProperty("http.proxyHost", "127.0.0.1");
////        System.setProperty("http.proxyPort", "8888");
////        System.setProperty("https.proxyHost", "127.0.0.1");
////        System.setProperty("https.proxyPort", "8888");
//        CallPhone s = new CallPhone(phoneConfig);
//        Thread thread = new Thread(s);
//        thread.run();
//        s.getResult();
//        System.out.println(phoneConfig);
//        return CommonResult.success(s.getResult());
//    }
//}
