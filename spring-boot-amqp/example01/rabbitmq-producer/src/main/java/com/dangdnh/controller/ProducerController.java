package com.dangdnh.controller;

import com.dangdnh.model.Student;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/producer")
public interface ProducerController {

    @PostMapping(value = "/students", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> send(@RequestBody Student student);
}
