package com.example.demo.Entity;

import lombok.Data;

import java.io.Serializable;


@Data
public class Template implements Serializable {

    private String style;
    private String app_id;
    private String template_id;
    private String title;
    private String data;
    private String code;
    private String message;
}
