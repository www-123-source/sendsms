package com.example.demo.Entity;

import lombok.Data;

@Data
public class HandlerConfig {

    private String statusCode;
    private String action;
    private String smsType;
    private String recvTime;
    private String apiVersion;
    private String fromNum;
    private String content;

}
