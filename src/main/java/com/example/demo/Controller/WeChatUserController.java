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
public class WeChatUserController {
    @ApiOperation("获取微信企业号成员")
    @PostMapping("/WeChatUser")
    @ResponseBody
    public CommonResult WeChatUser(WeChatConfig weChatConfig) {
        try {
            String c = HttpUtils.sendGet(

                    "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + weChatConfig.getID()+"&corpsecret=" + weChatConfig.getSECRET()
            );
            JSONObject json= JSONObject.parseObject(c);
            String ja =json.getString("access_token");
            System.out.println("token"+c);
            String f = HttpUtils.sendGet("https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?access_token=" +ja +"&department_id=" +weChatConfig.getDepartment_id());
            System.out.println(f);
            return CommonResult.success(f);
        } catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed();
        }
    }
}
