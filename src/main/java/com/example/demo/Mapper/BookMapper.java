package com.example.demo.Mapper;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.UploadBook;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    int deleteById(int id);

    int updateById(Book book);

    Book selectByUser_id(int user_id);

    int InsertUser(List<UploadBook> users);
}
