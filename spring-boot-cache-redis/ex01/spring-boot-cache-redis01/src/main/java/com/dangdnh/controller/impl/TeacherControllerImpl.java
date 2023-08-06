package com.dangdnh.controller.impl;

import com.dangdnh.controller.TeacherController;
import com.dangdnh.model.Teacher;
import com.dangdnh.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherControllerImpl implements TeacherController {

    private final TeacherService service;

    @Autowired
    public TeacherControllerImpl(TeacherService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<Teacher>> findAll() {
        List<Teacher> response = service.findAll();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Teacher> findById(String id) {
        Teacher response = service.findById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Teacher> create(Teacher teacher) {
        Teacher response = service.create(teacher);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Teacher> updateById(String id, Teacher teacher) {
        Teacher response = service.updateById(id, teacher);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> deleteById(String id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
