//package com.example.demo.utils;
//
//import com.aliyuncs.CommonRequest;
//import com.aliyuncs.CommonResponse;
//import com.aliyuncs.DefaultAcsClient;
//import com.aliyuncs.IAcsClient;
//import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
//import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
//import com.aliyuncs.exceptions.ClientException;
//import com.aliyuncs.exceptions.ServerException;
//import com.aliyuncs.http.MethodType;
//import com.aliyuncs.profile.DefaultProfile;
//import com.aliyuncs.profile.IClientProfile;
//
///**
// * 阿里云短信服务：
// * 注意：需要 签名名称、模版CODE 以及 RAM访问控制中的 AccessKeyID 和 AccessKeySecret
// */
//
//   public  class AliyunSendSms implements Runnable {
//    @Override
//    public void run() {
//
//            DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4GEeT7reH6aNpiB4FR3d", "dCRUjrJXnkXVQTDPsVn3lTy0mqJ55p");
//            IAcsClient client = new DefaultAcsClient(profile);
//
//            CommonRequest request = new CommonRequest();
//            request.setSysMethod(MethodType.POST);
//            request.setSysDomain("dysmsapi.aliyuncs.com");
//            request.setSysVersion("2017-05-25");
//            request.setSysAction("SendSms");
//            request.putQueryParameter("RegionId", "cn-hangzhou");
//            request.putQueryParameter("PhoneNumbers", "15908128683");
//            request.putQueryParameter("SignName", "dramstdio");
//            request.putQueryParameter("TemplateCode", "SMS_196659206");
//            request.putQueryParameter("TemplateParam", "{ \"code\": 123}");
//            try {
//                CommonResponse response = client.getCommonResponse(request);
//                System.out.println(response.getData());
//            } catch (ServerException e) {
//                e.printStackTrace();
//            }
//            catch (ClientException e) {
//                e.printStackTrace();
//            }
//
//
//    }
//}