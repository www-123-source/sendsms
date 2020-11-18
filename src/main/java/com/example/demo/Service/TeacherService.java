package com.example.demo.Service;

import com.example.demo.Entity.Teacher;

public interface TeacherService {

    int addTeacher(Teacher teacher);

    int deleteTeacher(int teacherId);

    int updateTeacher(Teacher teacher);

}
