package com.example.demo.Controller;

import com.alibaba.excel.EasyExcel;
import com.example.demo.Entity.Book;
import com.example.demo.Entity.UploadBook;
import com.example.demo.Service.BookService;
import com.example.demo.utils.BookDateListener;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Api(tags ="通讯录",description = "book")
@Controller
@RequestMapping("/test")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private UploadDAO uploadDAO;

    @ApiOperation("删除用户信息")
    @PostMapping("/delete")
    @ResponseBody
    public int delete(int id) {
        return bookService.deleteById(id);
    }

    @ApiOperation("修改用户信息")
    @PostMapping("/update")
    @ResponseBody
    public int updateById(Book book) {
        return bookService.updateById(book);
    }

    @ApiOperation("查询用户信息")
    @PostMapping("/select")
    @ResponseBody
    public Book selectById(int user_id) {
        return bookService.selectByUser_id(user_id);
    }


    @ApiOperation("导入用户表格")
    @PostMapping("/excel")
    @ResponseBody
    public void insertExcel(@RequestBody MultipartFile file) throws IOException {

        EasyExcel.read(file.getInputStream(), UploadBook.class, new BookDateListener.UploadDataListener(uploadDAO)).sheet().doRead();
    }
}
