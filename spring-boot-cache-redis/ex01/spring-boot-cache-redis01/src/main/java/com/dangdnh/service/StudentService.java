package com.dangdnh.service;

import com.dangdnh.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(String id);

    Student create(Student student);

    Student updateById(String id, Student student);

    void deleteById(String id);
}
