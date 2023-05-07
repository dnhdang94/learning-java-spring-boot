package com.dangdnh.controller;

import com.dangdnh.definition.URIs;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(URIs.HOME)
public class HomeController {

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Welcome!");
    }
}
