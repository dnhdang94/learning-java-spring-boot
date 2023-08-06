package com.dangdnh.controller;

import com.dangdnh.model.Teacher;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/teachers")
public interface TeacherController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Teacher>> findAll();

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Teacher> findById(@PathVariable String id);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Teacher> create(@RequestBody Teacher teacher);

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Teacher> updateById(@PathVariable String id, @RequestBody Teacher teacher);

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteById(@PathVariable String id);
}
