package com.example.demo.Service;

import com.example.demo.Entity.Teacher;

import java.util.List;

public interface TeacherService {

    int addTeacher(Teacher teacher);

    int deleteTeacher(int teacherId);

    int updateTeacher(Teacher teacher);

    List<Teacher> selectTeacherDepartment(String administrationDepartmentName, String workingDepartmentName, String JobPositionName );

}
