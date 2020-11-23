package com.example.demo.Mapper;

import com.example.demo.Entity.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagMapper {

    /**
     * 根据姓名设置标签
     */
//    @Insert(" insert into tag (tag_id,tag_name) VALUES(#{tagId},#{tagName}) ")
//    int insertTagName(String tagName, int tagId);

}
