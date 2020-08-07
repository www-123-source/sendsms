package com.example.demo.Service;

import com.example.demo.Entity.Login;


public interface LoginService {

    public Login loginIn(String user_number, String password);

    public int add(String user_name, String password, String user_number);

}
