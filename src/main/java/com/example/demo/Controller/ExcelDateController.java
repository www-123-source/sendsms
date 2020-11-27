package com.example.demo.Controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.example.demo.Entity.ExcelDate;
import com.example.demo.Entity.UploadBook;
import com.example.demo.Mapper.ExcelDateMapper;
import com.example.demo.utils.BookDateListener;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.utils.test.TestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Api(tags ="excel导入",description = "ExcelDate")
@Controller
@RequestMapping("/excel")

public class ExcelDateController {

    @Autowired
    ExcelDateMapper excelDateMapper;

    @ApiOperation("读取excel指定列")
    @PostMapping("/uploadWithAnonyInnerClass")
    public String uploadWithAnonyInnerClass(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), ExcelDate.class, new AnalysisEventListener<ExcelDate>(){
            /**
             * 批处理阈值
             */
            private static final int BATCH_COUNT = 200;
            List<ExcelDate> list = new ArrayList<ExcelDate>();

            @Override
            public void invoke(ExcelDate excelDate, AnalysisContext analysisContext) {
                log.info("解析到一条数据:{}", JSON.toJSONString(excelDate));
                list.add(excelDate);
                if (list.size() >= BATCH_COUNT) {
                    saveData();
                    list.clear();
                }
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                saveData();
                log.info("所有数据解析完成！");
            }

            private void saveData(){
                excelDateMapper.saveData(list);
            }
        }).sheet().doRead();
        return "success";
    }


}
