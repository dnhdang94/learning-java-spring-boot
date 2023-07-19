package com.dangdnh.repositories.student;

import com.dangdnh.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String>, StudentRepositoryCustom {

}
