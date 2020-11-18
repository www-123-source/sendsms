package com.example.demo.Controller;

import com.alibaba.excel.EasyExcel;
import com.example.demo.Entity.Book;
import com.example.demo.Entity.UploadBook;
import com.example.demo.Service.BookService;
import com.example.demo.utils.BookDateListener;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags ="通讯录",description = "book")
@Controller
@RequestMapping("/test")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private UploadDAO uploadDAO;

    @ApiOperation("删除用户信息")
    @DeleteMapping("/delete1")
    @ResponseBody
    public int delete(int id) {
        return bookService.deleteById(id);
    }

    @ApiOperation("修改用户信息")
    @PutMapping("/update")
    @ResponseBody
    public int updateById(@RequestBody Book book) {
        return bookService.updateById(book);
    }

    @ApiOperation("查询用户信息")
    @GetMapping("/select")
    @ResponseBody
    public List<Book> selectByUser_id(int user_id) {
        return bookService.selectByUser_id(user_id);
    }


    @ApiOperation("导入用户表格")
    @PostMapping("/excel")
    @ResponseBody
    public ResponseEntity insertUser(@RequestBody MultipartFile file,
                                      @RequestParam int user_id,
                                      @RequestParam int group_id) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
//        try {
            EasyExcel.read(file.getInputStream(), UploadBook.class, new BookDateListener.UploadDataListener(uploadDAO,user_id,group_id)).sheet().doRead();
//        }
//        catch (DuplicateKeyException de){
//            map.put("code", -2);   //  -2：插入重复用户
//            map.put("message","请勿插入重复用户");
//            return new ResponseEntity<Map<String, Object>>(map,HttpStatus.LOCKED);
//        }
//        catch (DataIntegrityViolationException de ){
//            map.put("code", -3);   //  -3：插入设备不存在
//            map.put("message","用户的设备格式错误");
//            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.LOCKED);
//        }
//        catch (Exception exception) {
//            map.put("code", -1);  // -1:未知错误
//            map.put("message","系统错误");
//            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.LOCKED);
//        }
        map.put("code", 1);
        map.put("message","导入成功");
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }


//    @ApiOperation("查询用户分组")
//    @PostMapping("/group1")
//    @ResponseBody
//    public List<Book> selectById(int id){return bookService.selectById(id);}

    @ApiOperation("分组查询联系人")
    @GetMapping("/group2")
    @ResponseBody
    public List<Book> selectByGroupId(int user_id){return bookService.selectByGroupId(user_id);}

    @ApiOperation("新增联系人")
    @PostMapping("/insert1")
    @ResponseBody
    public int insertBook (@RequestBody Book book){
        return bookService.insertBook(book);
    }
    @ApiOperation("模糊查询")
    @GetMapping("/FuzzySelect")
    @ResponseBody
    public List<Book> FuzzySelect(@RequestBody Book book){return bookService.FuzzySelect(book);}

}
