package com.example.demo.Controller;



import com.example.demo.Entity.Template;
import com.example.demo.Service.TemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags ="模板消息",description = "template")
@RestController
@RequestMapping("/test")
@Validated
public class TemplateController {
    @Autowired
    private TemplateService templateService;

    @ApiOperation("模板短信接口")
    @PostMapping("/template")
    @ResponseBody
    public List<Template> selectByStyle(){

        return templateService.selectByStyle();
    }

}