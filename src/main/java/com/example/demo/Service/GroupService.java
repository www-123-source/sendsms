package com.example.demo.Service;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.MyGroup;

import java.util.List;

public interface GroupService {


    List<MyGroup> selectById(int id);

    int insertGroup (MyGroup myGroup);

    int deleteByGroupId(int group_id);

    int updateByGroupId(MyGroup myGroup);
}
