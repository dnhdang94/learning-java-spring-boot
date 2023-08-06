package com.dangdnh.service.impl;

import com.dangdnh.definition.CacheNames;
import com.dangdnh.model.Student;
import com.dangdnh.repository.StudentRepository;
import com.dangdnh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = CacheNames.STUDENT)
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    @Cacheable(value = CacheNames.STUDENT_ALL_ENTRIES, unless = "#result.size() == 0")
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    @Cacheable(key = "#id")
    public Student findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity was not found"));
    }

    @Override
    public Student create(Student student) {
        return repository.insert(student);
    }

    @Override
    @Caching(
            put = {@CachePut(key = "#student.id")},
            evict = {@CacheEvict(value = CacheNames.STUDENT_ALL_ENTRIES, allEntries = true)}
    )
    public Student updateById(String id, Student student) {
        return repository.save(student);
    }

    @Override
    @CacheEvict(value = "#id")
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
