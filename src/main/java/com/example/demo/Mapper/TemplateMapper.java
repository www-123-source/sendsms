package com.example.demo.Mapper;


import com.example.demo.Entity.Template;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface TemplateMapper {


     List<Template> selectByStyle();
}
