package com.example.demo.Controller;

import com.example.demo.Entity.MessageConfig;
import com.example.demo.Entity.MyMessageConfig;
import org.apache.poi.util.StringUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author : JCccc
 * @CreateTime : 2019/9/3
 * @Description :
 **/
@RestController
public class SendMessageController {

    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法

    @PostMapping("/sendDirectMessage")
    public String sendDirectMessage(@RequestBody MessageConfig messageConfig) {
        System.out.println(messageConfig);
        MyMessageConfig myMessageConfig = new MyMessageConfig();
        myMessageConfig.setReplaceData(StringUtil.join(messageConfig.getReplaceData()));
        myMessageConfig.setSendPhones(messageConfig.getSendPhones());
        myMessageConfig.setTemplateId(messageConfig.getTemplateId());

        System.out.println(myMessageConfig);
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = myMessageConfig.toString();
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        System.out.println(map);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", map);

        return "ok";
    }


}