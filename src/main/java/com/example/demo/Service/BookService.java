package com.example.demo.Service;

import com.alibaba.fastjson.JSONArray;
import com.example.demo.Entity.Book;

import com.example.demo.Entity.UploadBook;

import java.util.List;


public interface BookService {

    int deleteById(int id);

    int updateById(Book book);

    List<Book> selectByUser_id(int user_id);

    int InsertUser(List<UploadBook> books,int user_id,int group_id);

    List<Book> selectByGroupId(int user_id);

    int insertBook (Book book);

    List<Book> FuzzySelect(Book book);

    Book selectByNum(String consignee_number);

    //    List<Book> selectById(int id);
}
