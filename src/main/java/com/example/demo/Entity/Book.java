package com.example.demo.Entity;

import lombok.Data;

@Data
public class Book {

    /**
     * book表中的
     */
    private int id;
    private int user_id;
    private String consignee_number;
    private String consignee_name;
    private String email;
    private int group_id;
    private String my_group;

    /**
     * myGroup表中的
     */
    private MyGroup myGroup;
    private Login login;

}
