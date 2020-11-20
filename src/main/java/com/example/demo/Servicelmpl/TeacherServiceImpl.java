package com.example.demo.Servicelmpl;

import com.example.demo.Entity.Teacher;
import com.example.demo.Mapper.TeacherMapper;
import com.example.demo.Service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    /**
     * 添加教师信息
     * @return
     */
    @Override
    public int addTeacher(Teacher teacher){
        return teacherMapper.addTeacher(teacher);
    }

    @Override
    public int deleteTeacher(int teacherId){
        return teacherMapper.deleteTeacher(teacherId);
    }

    @Override
    public int updateTeacher(Teacher teacher){
        return teacherMapper.updateTeacher(teacher);
    }

    @Override
    public List<Teacher> selectTeacherDepartment(String administrationDepartmentName, String workingDepartmentName, String JobPositionName,String tagName  ){
        return teacherMapper.selectTeacherDepartment(administrationDepartmentName,workingDepartmentName,JobPositionName,tagName);

    }

    @Override
    public int  updateTagName(String teacherName,String tagName){
        return teacherMapper.updateTagName(teacherName,tagName);
    }

    @Override
    public  int deleteTagName(String teacherName){
        return teacherMapper.deleteTagName(teacherName);
    }

}
