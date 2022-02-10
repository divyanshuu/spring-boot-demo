package com.example.springBootDemo.Service;

import com.example.springBootDemo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Transactional
    public void deleteDepartmentById(Integer id) {
        departmentRepository.deleteById(id);
    }
}
