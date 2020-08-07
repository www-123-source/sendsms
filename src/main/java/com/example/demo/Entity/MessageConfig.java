package com.example.demo.Entity;

import lombok.Data;

@Data
public class MessageConfig {

    private String sendPhones;
    private String templateId;
    private String[] replaceData;


}
