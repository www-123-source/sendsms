package com.example.demo.Entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class ExcelDate {

    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty("实际工作部门")
    private String number;

}
