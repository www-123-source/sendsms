package com.example.demo.Service;

import com.example.demo.Entity.Teacher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherService {

    int addTeacher(Teacher teacher);

    int deleteTeacher(int teacherId);

    int updateTeacher(Teacher teacher);

    List<Teacher> selectTeacherDepartment(String administrationDepartmentName, String workingDepartmentName, String JobPositionName,String tagName  );

    int updateTagName(String teacherName,String tagName);

    int deleteTagName(String teacherName);

    // int selectTeacher(Teacher teacher);

   // int insertTagName(String teacherName,int teacherTagId);

    int insertTag(String tagName,int tagId);
    int insertTagName(String teacherName,int teacherTagId);



}
