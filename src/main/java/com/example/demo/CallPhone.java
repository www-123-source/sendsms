//package com.example.demo;
//
//import com.example.demo.Entity.PhoneConfig;
//import com.example.demo.utils.CCPRestSDK;
//import lombok.Data;
//
//import java.util.HashMap;
//import java.util.Set;
//
//@Data
//public class CallPhone implements Runnable{
//    private PhoneConfig phoneConfig;
//
//    private HashMap<String, Object> result;
//
//    public CallPhone(PhoneConfig phoneConfig){
//        this.phoneConfig=phoneConfig;
//    }
//    public void run(){
//        CCPRestSDK restAPI = new CCPRestSDK();
//        restAPI.init("app.cloopen.com", "8883");// 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
//        restAPI.setAccount("aaf98f894f402f15014f47296f9305b6", "4c3bf9a9f1114bd2a85d1de6552a3143");// 初始化主帐号和主帐号TOKEN
//        restAPI.setAppId("8a48b5514f49079e014f4ae30b730723");// 初始化应用ID
//        //type=1，则播放默认语音文件,0是自定义语音文件
//        result = restAPI.landingCall(
//                "15908128683",
//                "229189149233159179.wav",
//                "",
//                "",
//                "3",
//                "",
//                "",
//                "",
//                "",
//                "",
//                "",
//                "");
//
//        System.out.println("SDKTestLandingCall result=" + result);
//
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
//    }
