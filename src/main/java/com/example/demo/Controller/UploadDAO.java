package com.example.demo.Controller;

import com.example.demo.Entity.UploadBook;
import com.example.demo.Service.BookService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Controller
public class UploadDAO {
    @Autowired
    private BookService bookService;

    @SneakyThrows
    public void save(List<UploadBook> list,int hhh,int aaa) throws DuplicateKeyException {
        bookService.InsertUser(list, hhh, aaa);


    }
}
