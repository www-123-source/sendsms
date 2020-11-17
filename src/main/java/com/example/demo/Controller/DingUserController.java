package com.example.demo.Controller;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiUserGetByMobileRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiUserGetByMobileResponse;
import com.example.demo.Entity.DingConfig;
import com.example.demo.Entity.MessageConfig;
import com.taobao.api.ApiException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import result.CommonResult;

import java.util.HashMap;

@Api(tags = "必达消息", description = "message")
@RestController
@RequestMapping("/test")
@Log4j2
@Data
public class DingUserController {
    @ApiOperation("钉钉用户")
    @PostMapping("/DingUser")
    @ResponseBody

    public CommonResult DingUser(String PhoneNumber) throws ApiException
    {
        DingConfig dingConfig = new DingConfig();
        dingConfig.setMobilePhone(PhoneNumber);
        DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey("ding753uwtpkzwy8zu3v");
        request.setAppsecret("tF7Yi6jrmODdZwNL2YED-aLckg4MxDtOfh6xj7ZEXW80ki_QzF8_c2H_btjRy-y2");
        request.setHttpMethod("GET");
        OapiGettokenResponse response = client.execute(request);

        DingTalkClient client2 = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/get_by_mobile");
        OapiUserGetByMobileRequest request2 = new OapiUserGetByMobileRequest();
        request2.setMobile(PhoneNumber);
        request2.setHttpMethod("GET");
        OapiUserGetByMobileResponse execute = client2.execute(request2, response.getAccessToken());
        return CommonResult.success(execute);
    }
}
