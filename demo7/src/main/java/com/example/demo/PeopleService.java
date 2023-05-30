package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {
    @Autowired
    private PeopleRepository repo2;

    public List<People> listAll(String keyword) {
        if (keyword != null) {
            return repo2.search(keyword);
        }
        return repo2.findAll();
    }

    public void save(People student) {
        repo2.save(student);
    }

    public People get(Long id) {
        return repo2.findById(id).get();
    }

    public void delete(Long id) {
        repo2.deleteById(id);
    }

}