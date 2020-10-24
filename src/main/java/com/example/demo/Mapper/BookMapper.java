package com.example.demo.Mapper;

import com.alibaba.fastjson.JSONArray;
import com.example.demo.Entity.Book;
import com.example.demo.Entity.UploadBook;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    int deleteById(int id);

    int updateById(Book book);

    List<Book> selectByUser_id(int user_id);

    int InsertUser(List<Book> books);


//    List<Book> selectById(int id);

    List<Book> selectByGroupId(int user_id);

    int insertBook (Book book);

    List<Book> FuzzySelect(Book book);

    Book selectByNum(String consignee_number);
}
