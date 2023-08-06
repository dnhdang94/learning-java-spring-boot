package com.dangdnh.controller.impl;

import com.dangdnh.controller.StudentController;
import com.dangdnh.model.Student;
import com.dangdnh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentControllerImpl implements StudentController {

    private final StudentService service;

    @Autowired
    public StudentControllerImpl(StudentService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<Student>> findAll() {
        List<Student> response = service.findAll();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Student> findById(String id) {
        Student response = service.findById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Student> create(Student student) {
        Student response = service.create(student);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Student> updateById(String id, Student student) {
        Student response = service.updateById(id, student);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> deleteById(String id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
