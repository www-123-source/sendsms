package com.example.demo.Controller;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.Entity.WeChatConfig;
import com.example.demo.utils.HttpUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import result.CommonResult;


@Api(tags = "必达消息", description = "message")
@RestController
@RequestMapping("/test")
@Log4j2
public class WeChatController {
    @ApiOperation("微信企业号")
    @PostMapping("/WeChatSend")
    @ResponseBody
    public CommonResult WeChatSend(WeChatConfig weChatConfig,@RequestBody JSONObject jsonObject) {
        try {
            System.out.println("内容"+jsonObject);
            System.out.print("https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + weChatConfig.getID()+"&corpsecret=" + weChatConfig.getSECRET());
            String c = HttpUtils.sendGet(

                    "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + weChatConfig.getID()+"&corpsecret=" + weChatConfig.getSECRET()
            );
            JSONObject json= JSONObject.parseObject(c);
            String ja =json.getString("access_token");
            System.out.println("token"+c);
            String d = HttpUtils.sendPost(
                    "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=" + ja,jsonObject.toString()
//                    "{"
//                            + "\"touser\": \"@all\","
//                            +"\"msgtype\": \"text\","
//                            +"\"agentid\":\"1000002\","
//                            +"\"text\": {" +
//                            "\"content\": \"哈哈哈\"," +
//                            "}"
//                            + "}"


            );
            System.out.println(d);
            return CommonResult.success(d);
        } catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed();
        }
    }
}


