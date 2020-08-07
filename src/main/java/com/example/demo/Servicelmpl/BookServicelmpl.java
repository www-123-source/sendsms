package com.example.demo.Servicelmpl;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.UploadBook;
import com.example.demo.Mapper.BookMapper;
import com.example.demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookServicelmpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public int deleteById(int id) {return bookMapper.deleteById(id);}

    @Override
    public int updateById(Book book) {return bookMapper.updateById(book);}

    @Override
    public Book selectByUser_id(int user_id) { return bookMapper.selectByUser_id(user_id);}

    @Override
    public int InsertUser(List<UploadBook> users) {
        return bookMapper.InsertUser(users);
    }

}
