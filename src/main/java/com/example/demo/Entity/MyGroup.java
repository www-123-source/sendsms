package com.example.demo.Entity;

import lombok.Data;

@Data
public class MyGroup {


    private int group_id;
    private int user_id;
    private String my_group;

    private Book book;
    private Login login;
}
