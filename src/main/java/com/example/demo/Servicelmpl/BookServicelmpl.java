package com.example.demo.Servicelmpl;

import com.alibaba.fastjson.JSONArray;
import com.example.demo.Entity.Book;
import com.example.demo.Entity.UploadBook;
import com.example.demo.Mapper.BookMapper;
import com.example.demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class BookServicelmpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public int deleteById(int id) {
        return bookMapper.deleteById(id);
    }

    @Override
    public int updateById(Book book) {
        return bookMapper.updateById(book);
    }

    @Override
    public List<Book> selectByUser_id(int user_id) {
        return bookMapper.selectByUser_id(user_id);
    }

    @Override
    public int InsertUser(List<UploadBook> books, int user_id, int group_id) {
        List<Book> b = new ArrayList<>();
        for (UploadBook uploadBook : books) {
            Book book = new Book();
            book.setConsignee_number(uploadBook.getConsignee_number());
            book.setEmail(uploadBook.getEmail());
            book.setConsignee_name(uploadBook.getConsignee_name());
            book.setUser_id(user_id);
            book.setGroup_id(group_id);
            b.add(book);
        }


        return bookMapper.InsertUser(b);
    }

//    @Override
//    public List<Book> selectById(int id) {return bookMapper.selectById(id);}

    @Override
    public List<Book> selectByGroupId(int user_id) {
        return bookMapper.selectByGroupId(user_id);
    }

    @Override
    public int insertBook(Book book) {


        return bookMapper.insertBook(book);
    }

    @Override
    public List<Book> FuzzySelect(Book book) {
        return bookMapper.FuzzySelect(book);
    }

    @Override
    public Book selectByNum(String consignee_number) {
        return bookMapper.selectByNum(consignee_number);


    }
}
