package com.example.demo.Servicelmpl;

import com.example.demo.Entity.Login;
import com.example.demo.Mapper.LoginMapper;
import com.example.demo.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class LoginServicelmpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Login loginIn(String user_number, String password) {return loginMapper.getInfo(user_number, password);}

    @Override
    public int add(String user_name, String password, String user_number) {return loginMapper.add(user_name,password,user_number);}



}
