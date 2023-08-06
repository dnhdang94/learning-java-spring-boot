package com.dangdnh.service;

import com.dangdnh.model.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> findAll();

    Teacher findById(String id);

    Teacher create(Teacher teacher);

    Teacher updateById(String id, Teacher teacher);

    void deleteById(String id);
}
