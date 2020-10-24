package com.example.demo.Service;

import com.alibaba.fastjson.JSONArray;
import com.example.demo.Entity.Book;

import com.example.demo.Entity.UploadBook;

import java.util.List;


public interface BookService {
    public int deleteById(int id);
    public int updateById(Book book);
    List<Book> selectByUser_id(int user_id);
    int InsertUser(List<UploadBook> books,int user_id,int group_id);
//    List<Book> selectById(int id);
    List<Book> selectByGroupId(int user_id);

    int insertBook (Book book);

    List<Book> FuzzySelect(Book book);

    Book selectByNum(String consignee_number);
}
