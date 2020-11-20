package com.example.demo.Mapper;



import com.example.demo.Entity.MyGroup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupMapper {

        List<MyGroup> selectById(int id);

        int insertGroup (MyGroup myGroup);

        int deleteByGroupId(int group_id);

        int updateByGroupId(MyGroup myGroup);
}
