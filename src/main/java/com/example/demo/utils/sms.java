package com.example.demo.utils;


import com.cloopen.rest.sdk.CCPRestSmsSDK;

import java.util.HashMap;
import java.util.Set;

//public class SendSms implements Runnable {
//    public void run() {
//        //测试
//        public static String ACCOUNT_SID = "*************";
//        public static String ACCOUNT_TOKEN = "************";
//        public static String ACCOUNT_APPID = "***********";
//
//
//            //生产环境请求地址：app.cloopen.com
//            String serverIp = "app.cloopen.com";
//            //请求端口
//            String serverPort = "8883";
//            //请使用管理控制台中已创建应用的APPID
//            String appId = "************";
//            CCPRestSmsSDK sdk = new CCPRestSmsSDK();
//            sdk.init(serverIp, serverPort);
//            sdk.setAccount(ACCOUNT_SID, ACCOUNT_TOKEN);
//            sdk.setAppId(ACCOUNT_APPID);
//
//            sdk.setBodyType(BodyType.Type_JSON);
//            String to = "*******";  //绑定的测试手机号
//            String templateId = "1";   //短信模板
//            String[] datas = {"2"};   //分钟参数
//
//            HashMap<String, Object> result = sdk.sendTemplateSMS(to, templateId, datas);
//
//            if ("000000".equals(result.get("statusCode"))) {
//                //正常返回输出data包体信息（map）
//                HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
//                Set<String> keySet = data.keySet();
//                for (String key : keySet) {
//                    Object object = data.get(key);
//                    System.out.println(key + " = " + object);
//                }
//            } else {
//                //异常返回输出错误码和错误信息
//                System.out.println("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
//            }
//
//        }
//
//
//    }







//import com.cloopen.rest.sdk.CCPRestSmsSDK;
//import com.cloopen.rest.sdk.BodyType;
//
//import java.rmi.ServerException;
//import java.util.HashMap;
//import java.util.Set;









//public class sms implements Runnable{
//        public void run(){
//        HashMap<String, Object> result = null;
//        CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
//        restAPI.init("app.cloopen.com", "8883");
//        // 初始化服务器地址和端口，生产环境配置成app.cloopen.com，端口是8883.
//        restAPI.setAccount("8aaf0708732220a601739359887531af", "48408b50d1d24485ab2485d785491ae6");
//        // 初始化主账号名称和主账号令牌，登陆云通讯网站后，可在控制首页中看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN。
//        restAPI.setAppId("8aaf0708732220a601739359896d31b6");
//        // 请使用管理控制台中已创建应用的APPID。
//        result = restAPI.sendTemplateSMS("15908128683","1" ,new String[]{"456789"});
//        System.out.println("SDKTestGetSubAccounts result=" + result);
//        if("000000".equals(result.get("statusCode"))){
//            //正常返回输出data包体信息（map）
//            HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
//            Set<String> keySet = data.keySet();
//            for(String key:keySet){
//                Object object = data.get(key);
//                System.out.println(key +" = "+object);
//            }
//        }else{
//            //异常返回输出错误码和错误信息
//            System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
//        }
//    }
//
//}
