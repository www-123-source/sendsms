package com.example.demo.Entity;

import lombok.Data;

@Data
public class DingConfig {
    /**
     * 钉钉API调用需要的字段
     */
    private String setDepartmentId;
    private String setOffset;
    private String setSize;
    private String setHttpMethod;
    private String mobilePhone;
    private String button;

}
