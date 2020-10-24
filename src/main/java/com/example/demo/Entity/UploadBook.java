package com.example.demo.Entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.Value;

@Data
public class UploadBook {


    private String consignee_number;
    private String consignee_name;
    private String email;



}
