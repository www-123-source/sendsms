package com.example.demo.Servicelmpl;

import com.example.demo.Entity.Template;
import com.example.demo.Mapper.TemplateMapper;
import com.example.demo.Service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TemplateServicelmpl implements TemplateService {
    @Autowired
    private TemplateMapper templateMapper;

    @Override
    public List<Template> selectByStyle(){

        return templateMapper.selectByStyle();
    }
}
