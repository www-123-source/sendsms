package com.example.demo.Servicelmpl;

import com.alibaba.fastjson.JSON;
import com.example.demo.Entity.ExcelDate;
import com.example.demo.Mapper.ExcelDateMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ExcelDateServiceImpl implements ExcelDateMapper {

    @Override
    public boolean saveData(List<ExcelDate> excelDates) {
        log.info("UserService {}条数据，开始存储数据库！", excelDates.size());
        log.info(JSON.toJSONString(excelDates));
        log.info("UserService 存储数据库成功！");
        return true;
    }


}
