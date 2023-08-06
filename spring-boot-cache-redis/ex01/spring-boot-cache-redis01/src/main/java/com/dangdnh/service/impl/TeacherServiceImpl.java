package com.dangdnh.service.impl;

import com.dangdnh.definition.CacheNames;
import com.dangdnh.model.Teacher;
import com.dangdnh.repository.TeacherRepository;
import com.dangdnh.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = CacheNames.TEACHER)
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository repository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository repository) {
        this.repository = repository;
    }

    @Override
    @Cacheable(value = CacheNames.TEACHER_ALL_ENTRIES, unless = "#result.size() == 0")
    public List<Teacher> findAll() {
        return repository.findAll();
    }

    @Override
    @Cacheable(key = "#id")
    public Teacher findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity was not found"));
    }

    @Override
    public Teacher create(Teacher teacher) {
        return repository.insert(teacher);
    }

    @Override
    @Caching(
            put = {@CachePut(key = "#teacher.id")},
            evict = {@CacheEvict(value = CacheNames.TEACHER_ALL_ENTRIES, allEntries = true)}
    )
    public Teacher updateById(String id, Teacher teacher) {
        return repository.save(teacher);
    }

    @Override
    @CacheEvict(value = "#id")
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
