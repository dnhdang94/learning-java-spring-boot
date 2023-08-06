package com.dangdnh.controller;

import com.dangdnh.model.Student;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/students")
public interface StudentController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Student>> findAll();

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Student> findById(@PathVariable String id);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Student> create(@RequestBody Student student);

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Student> updateById(@PathVariable String id, @RequestBody Student student);

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteById(@PathVariable String id);
}
