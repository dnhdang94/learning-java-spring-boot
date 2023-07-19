package com.dangdnh.repositories.student.impl;

import com.dangdnh.repositories.student.StudentRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryCustomImpl implements StudentRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public StudentRepositoryCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
}
