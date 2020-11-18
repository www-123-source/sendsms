package com.example.demo.Mapper;

import com.example.demo.Entity.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper {

    @Insert({"insert into teacher(id,teacher_name,teacher_id,administration_department_id,working_department_id,sex," +
            "organization,working_status,office_id,Job_position_id,class_status,phone_number,remark,office_director) " +
            "values(#{id},#{teacherName},#{teacherId},#{administrationDepartmentId},#{workingDepartmentId},#{sex}," +
            "#{organization},#{workingStatus},#{officeId},#{JobPositionId},#{classStatus},#{phoneNumber},#{remark},#{officeDirector})"})
    int addTeacher(Teacher teacher);

    @Delete("delete from teacher where teacher_id = #{teacherId}")
    int deleteTeacher(int teacherId);

    int updateTeacher(Teacher teacher);

}
