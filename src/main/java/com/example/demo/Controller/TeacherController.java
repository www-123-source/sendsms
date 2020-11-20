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
    public List<Teacher> selectTeacherDepartment(String administrationDepartmentName, String workingDepartmentName, String JobPositionName ){
        return teacherService.selectTeacherDepartment(administrationDepartmentName,workingDepartmentName,JobPositionName);
    }

}
