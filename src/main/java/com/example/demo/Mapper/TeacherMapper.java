package com.example.demo.Mapper;

import com.example.demo.Entity.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper {

    /**
     * 往教室表中添加数据
     * @param teacher
     * @return
     */
    @Insert({"insert into teacher(id,teacher_name,teacher_id,administration_department_id,working_department_id,sex," +
            "organization,working_status,office_id,Job_position_id,class_status,phone_number,remark,office_director) " +
            "values(#{id},#{teacherName},#{teacherId},#{administrationDepartmentId},#{workingDepartmentId},#{sex}," +
            "#{organization},#{workingStatus},#{officeId},#{JobPositionId},#{classStatus},#{phoneNumber},#{remark},#{officeDirector})"})
    int addTeacher(Teacher teacher);//方法

    /**
     * 根据 teacherId 删除教师信息
     * @param teacherId
     * @return
     */
    @Delete("delete from teacher where teacher_id = #{teacherId}")
    int deleteTeacher(int teacherId);

    /**
     * 根据 teacherId 删除教师信息
     * @param teacher
     * @return
     */
    int updateTeacher(Teacher teacher);

    /**
     * 条件查询教师所属部门
     * @param administrationDepartmentName
     * @param workingDepartmentName
     * @param JobPositionName
     * @return
     */
    List<Teacher> selectTeacherDepartment(String administrationDepartmentName, String workingDepartmentName, String JobPositionName );
}
