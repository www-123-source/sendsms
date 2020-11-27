package com.example.demo.Mapper;

import com.example.demo.Entity.ExcelDate;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface ExcelDateMapper {

    @Insert("insert into demo(name,number) values (#{name},#{number})")
    boolean saveData(List<ExcelDate> excelDates);

}
