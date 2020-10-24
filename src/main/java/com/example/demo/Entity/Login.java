package com.example.demo.Entity;

import lombok.Data;

@Data
public class Login {
    private int id;
    private String user_name;
    private String password;

    private String user_number;

    private Book book;
    private MyGroup myGroup;


}
