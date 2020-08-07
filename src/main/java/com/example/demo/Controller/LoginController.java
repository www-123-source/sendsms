package com.example.demo.Controller;

import com.example.demo.Service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;




@Api(tags ="登录与注册",description = "login")
@Controller
@RequestMapping("/test")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ApiOperation("用户登录")
    @PostMapping("/login")
    @ResponseBody
    public String Login(String user_number, String password) {
        System.out.println("输入进来的账号" + user_number);
        System.out.println("输入进来的密码" + password);

        if (loginService.loginIn(user_number, password) != null) {

            return "登录成功";
        } else
            System.out.println();
            return "登录失败";
    }

    @ApiOperation("用户注册")
    @PostMapping("/add")
    @ResponseBody
    public String add( String user_name, String password,String user_number) {
        System.out.println("输入进来的账号" + user_number);
        System.out.println("输入进来的密码" + password);
        System.out.println("输入进来的用户姓名" + user_name);
        try {
            loginService.add(user_name,password,user_number);
            return "注册成功";
        }
            catch(Exception e){
            return "注册失败";
            
        }


    }





}












