package com.example.demo;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.example.demo.Entity.MessageConfig;
import lombok.Data;
import java.util.HashMap;
import java.util.Set;

@Data
public class sms implements Runnable{

    private MessageConfig messageConfig;

    private HashMap<String, Object> result;

    public sms(MessageConfig messageConfig){
        this.messageConfig=messageConfig;
    }

    public void run(){
//        try {
//
//            Thread.sleep(10000);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
        CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
        restAPI.init("app.cloopen.com", "8883");
        // 初始化服务器地址和端口，生产环境配置成app.cloopen.com，端口是8883.
        restAPI.setAccount(
                "aaf98f894f402f15014f47296f9305b6", "4c3bf9a9f1114bd2a85d1de6552a3143");
        // 初始化主账号名称和主账号令牌，登陆云通讯网站后，可在控制首页中看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN。
        restAPI.setAppId("8aaf0708754a3ef2017572b5ce560d55");
        // 请使用管理控制台中已创建应用的APPID。
//        result = restAPI.sendTemplateSMS("******","***" ,new String[]{"123","2"});
        result = restAPI.sendTemplateSMS(messageConfig.getSendPhones(),messageConfig.getTemplateId(),messageConfig.getReplaceData());
        System.out.println("SDKTestGetSubAccounts result=" + result);
        if("000000".equals(result.get("statusCode"))){
            //正常返回输出data包体信息（map）
            HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for(String key:keySet){
                Object object = data.get(key);
                System.out.println(key +" = "+object);
            }
        }else{
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
        }
    }





}


