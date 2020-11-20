package com.example.demo.Entity;

import lombok.Data;

@Data
public class Tag {

    /***
     * tag 表中数据
     */
    private int id;
    private int tagId;
    private String tagName;

    /***
     * tagmap 表中数据
     */
    private int teacherId;
    private int teacherTagId;

}
