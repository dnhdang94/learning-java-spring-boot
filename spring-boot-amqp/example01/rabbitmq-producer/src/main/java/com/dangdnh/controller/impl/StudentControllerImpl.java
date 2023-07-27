package com.dangdnh.controller.impl;

import com.dangdnh.controller.ProducerController;
import com.dangdnh.model.Student;
import com.dangdnh.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class StudentControllerImpl implements ProducerController {

    private final ProducerService service;

    @Autowired
    public StudentControllerImpl(ProducerService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<Void> send(Student student) {
        service.send(student);
        return ResponseEntity.ok().build();
    }
}
