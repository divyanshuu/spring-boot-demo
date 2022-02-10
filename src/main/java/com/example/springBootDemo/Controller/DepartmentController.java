package com.example.springBootDemo.Controller;

import com.example.springBootDemo.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("department/api/v1")

public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @DeleteMapping(value = "/deleteDepartmentById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id) {
        departmentService.deleteDepartmentById(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
}
