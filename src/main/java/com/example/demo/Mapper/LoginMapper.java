package com.example.demo.Mapper;


import com.example.demo.Entity.Login;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface LoginMapper {

    Login getInfo(String user_number, String password) ;

    int add(String user_name,String password,String user_number);


}
