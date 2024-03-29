package com.example.demo.Entity;

import lombok.Data;

@Data
public class Teacher {
       /**
        * teacher 表中字段
        */
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


       /**
        * administration_department 表中的数据
        */

       private String administrationDepartmentName;
       /**
        * job_position 表中的数据
        */
       private String JobPositionName;
       /**
        * working_department 表中的数据
        */
       private String workingDepartmentName;

        /***
         * tag 表中数据
         */
        private int tagId;
        private String tagName;

        /***
         * tagmap 表中数据
         */
       // private int teacherId;
        private int teacherTagId;
}
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