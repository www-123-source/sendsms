package com.example.demo.Controller;

import com.example.demo.Entity.Teacher;
import com.example.demo.Service.TeacherService;
import com.example.demo.Servicelmpl.TeacherServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import result.CommonResult;

import java.util.List;

@Api(tags ="教师信息",description = "teacher")
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @ApiOperation("教师信息添加")
    @PostMapping("/add")
    public int addTeacher(Teacher teacher){
        return teacherService.addTeacher(teacher);
    }

    @ApiOperation("通过id删除教师信息")
    @DeleteMapping("/delete")
    public int  deleteTeacher(int teacherId){
        return teacherService.deleteTeacher(teacherId);
    }

    @ApiOperation("通过id修改教师信息")
    @PutMapping("/update")
    public int  updateTeacher(Teacher teacher){
        return teacherService.updateTeacher(teacher);
    }

    @ApiOperation("根据部门信息查询教师姓名和电话号码")
    @GetMapping("/selectDepartment")
    public List<Teacher> selectTeacherDepartment(String administrationDepartmentName, String workingDepartmentName, String JobPositionName,String tagName  ){
        return teacherService.selectTeacherDepartment(administrationDepartmentName,workingDepartmentName,JobPositionName,tagName);
    }

    @ApiOperation("根据 teacherName 修改标签名")
    @PostMapping("/updateTagName")
    public int  updateTagName(String teacherName,String tagName){
        return teacherService.updateTagName(teacherName,tagName);
    }

    @ApiOperation("根据 teacherName 删除标签名")
    @DeleteMapping("/deleteTagName")
    public  int deleteTagName(String teacherName){
        return teacherService.deleteTagName(teacherName);
    }

    @ApiOperation("给教师设置标签与id")
    @PostMapping("/addTagAndId")
    public String insertTagAndId(String teacherName,int teacherTagId,String tagName,int tagId){

        teacherService.insertTagName(teacherName,teacherTagId);
        teacherService.insertTag(tagName,tagId);
        return "设置标签与id成功";
    }

//    @ApiOperation("给教师设置标签")
//    @PostMapping("/addTag")
//    public int insertTagName(String teacherName,String tagName ,int tagId,int teacherTagId){
//        teacherService.insertTagName(teacherName,teacherTagId);
//        return teacherService.insertTagName(tagName,tagId);
//    }

//    @ApiOperation("给教师设置标签id")
//    @PostMapping("/addTagId")
//    public int insertTagName(String teacherName,int teacherTagId){
//        return teacherService.insertTagName(teacherName,teacherTagId);
//    }
//
//    @ApiOperation("给教师设置标签")
//    @PostMapping("/addTag")
//    public int insertTag(String tagName,int tagId){
//        return teacherService.insertTag(tagName,tagId);
//    }




}
