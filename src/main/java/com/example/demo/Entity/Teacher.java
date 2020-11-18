package com.example.demo.Entity;

import lombok.Data;

@Data
public class Teacher {
 /**
  `id` int(11)
  `teacher_name` varchar(255)
  `teacher_id` int(11)
  `administration_derpartment_id` int(11)
  `working_department_id` int(11)
  `sex` enum('男','女','保密')
            `organization` enum('在编','编外')
            `working_status` enum('在岗','病休')
            `office_id` int(11)
  `Job_position_id` int(11)
  `class_status` enum('校内专任','其他')
            `phone_number` varchar(11)
  `remark` text COLLATE utf8mb4_bin,
            `office_director` enum('教研室主任')*/


        private int id;
        private String teacherName;
        private int teacherId;
        private int administrationDepartmentId;
        private int workingDepartmentId;
        private String sex;
        private String organization;
        private String workingStatus;
        private int officeId;
        private int JobPositionId;
        private String classStatus;
        private String phoneNumber;
        private String remark;
        private String officeDirector;


}
