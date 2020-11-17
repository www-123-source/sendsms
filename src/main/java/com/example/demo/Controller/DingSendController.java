package com.example.demo.Controller;

import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.example.demo.Entity.DingConfig;
import com.example.demo.utils.HttpUtils;
import com.taobao.api.ApiException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import result.CommonResult;

@Api(tags = "必达消息", description = "message")
@RestController
@RequestMapping("/test")
@Log4j2
public class DingSendController {
    @ApiOperation("钉钉消息")
    @PostMapping("/DingSend")
    @ResponseBody

    public CommonResult DingSend(@RequestBody JSONObject jsonObject) throws ApiException {
//        System.setProperty("http.proxyHost", "127.0.0.1");
//        System.setProperty("http.proxyPort", "8888");
//        System.setProperty("https.proxyHost", "127.0.0.1");
//        System.setProperty("https.proxyPort", "8888");
        DingConfig dingConfig = new DingConfig();
        DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey("ding753uwtpkzwy8zu3v");
        request.setAppsecret("tF7Yi6jrmODdZwNL2YED-aLckg4MxDtOfh6xj7ZEXW80ki_QzF8_c2H_btjRy-y2");
        request.setHttpMethod("GET");
        OapiGettokenResponse response = client.execute(request);

//        DingTalkClient client2 = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2");
//
//        OapiMessageCorpconversationAsyncsendV2Request request2 = new OapiMessageCorpconversationAsyncsendV2Request();
//        request2.setUseridList("manager1897");
//        request2.setAgentId((long) 873786380);
//        request2.setToAllUser(false);
//        OapiMessageCorpconversationAsyncsendV2Request.Msg msg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();


//        msg.setMsgtype("text");
//        msg.setText(new OapiMessageCorpconversationAsyncsendV2Request.Text());
//        msg.getText().setContent("test123");
//        request2.setMsg(msg);
//
//        msg.setMsgtype("image");
//        msg.setImage(new OapiMessageCorpconversationAsyncsendV2Request.Image());
//        msg.getImage().setMediaId("@lADOdvRYes0CbM0CbA");
//        request2.setMsg(msg);
////
//        msg.setMsgtype("file");
//        msg.setFile(new OapiMessageCorpconversationAsyncsendV2Request.File());
//        msg.getFile().setMediaId("@lADOdvRYes0CbM0CbA");
//        request2.setMsg(msg);
//
//        msg.setMsgtype("link");
//        msg.setLink(new OapiMessageCorpconversationAsyncsendV2Request.Link());
//        msg.getLink().setTitle("test");
//        msg.getLink().setText("test");
//        msg.getLink().setMessageUrl("test");
//        msg.getLink().setPicUrl("test");
//        request2.setMsg(msg);
//
//        msg.setMsgtype("markdown");
//        msg.setMarkdown(new OapiMessageCorpconversationAsyncsendV2Request.Markdown());
//        msg.getMarkdown().setText("##### text");
//        msg.getMarkdown().setTitle("### Title");
//        request2.setMsg(msg);
//
//        msg.setOa(new OapiMessageCorpconversationAsyncsendV2Request.OA());
//        msg.getOa().setHead(new OapiMessageCorpconversationAsyncsendV2Request.Head());
//        msg.getOa().getHead().setText("head");
//        msg.getOa().setBody(new OapiMessageCorpconversationAsyncsendV2Request.Body());
//        msg.getOa().getBody().setContent("xxx");
//        msg.setMsgtype("oa");
//        request2.setMsg(msg);

//        msg.setActionCard(new OapiMessageCorpconversationAsyncsendV2Request.ActionCard());
//        msg.getActionCard().setTitle("校讯通");
//        msg.getActionCard().setMarkdown("### 督导老师，请宁在这周五3：00于3a101听课");
//        msg.getActionCard().setBtnOrientation("1");
//        ArrayList a1=new ArrayList();
//        a1.add("确认");
//        a1.add("www.baidu.com");
//        msg.getActionCard().setBtnJsonList(a1);
//
////        msg.getActionCard().setSingleTitle("百度搜索");
////        msg.getActionCard().setSingleUrl("https://www.baidu.com");
//        msg.setMsgtype("action_card");
//        request2.setMsg(msg);

//        OapiMessageCorpconversationAsyncsendV2Response response2 = client2.execute(request2,response.getAccessToken());
//        return CommonResult.success(response2);
        try {
            System.out.println("内容"+jsonObject);
            String b = HttpUtils.sendPost(
                    "https://oapi.dingtalk.com/message/send?access_token=" + response.getAccessToken(),jsonObject.toString()
//                    "{"
//                            + "\"touser\": \"manager1897\","//发送用户ID，多个用,分割
////                            + "\"toparty\": \"ding3f330935287a649ca39a90f97fcb1e09\","//发送部门ID，多个用,分割
//                            + "\"agentid\": \"873786380\","
//                            + "\"msgtype\": \"action_card\","
//                            + "\"action_card\": {" +
//                            "\"title\": \"听课通知\"," +
//                            "\"markdown\": \"督导老师，你的听课安排如下:周一下午三点3a101听李老师的课:\"," +
//                            "\"btn_orientation\": \"1\"," +
//                            "\"btn_json_list\": " +
//                            "[" +
//                            "{" +
//                            "\"title\": \"查看\","+
//                            "\"action_url\": \"https://www.taobao.com\","+
//                            "}" +
//                            "]" +
//                            "}"
//                            + "}"
            );
            System.out.println(response.getAccessToken());
            System.out.println(b);
            return CommonResult.success(b);
        }
        catch (Exception e) {
            log.error(e.getMessage());
            return CommonResult.failed();
        }
    }
}

