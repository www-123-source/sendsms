package com.example.demo.Service;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.UploadBook;

import java.util.List;


public interface BookService {
    public int deleteById(int id);
    public int updateById(Book book);
    Book selectByUser_id(int user_id);
    int InsertUser(List<UploadBook> users);
}
