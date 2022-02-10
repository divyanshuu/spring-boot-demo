package com.example.springBootDemo.Controller;

import com.example.springBootDemo.Service.EmployeeService;
import com.example.springBootDemo.dtos.EmployeeDTO;
import com.example.springBootDemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import java.util.List;

@RestController
@RequestMapping("employee/api/v1")
@Validated
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    //@RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping(value = "/hello")
    public String print() {
        return "helooo!!";
    }

    @GetMapping(value = "/allEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee>  employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping(value = "/fetch/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Integer id) {
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping(value = "/fetch")
    public ResponseEntity<Object> getById2(@RequestParam Integer id) {

        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.OK);
        }

    }

    @PostMapping(value = "/saveEmployee")
    public ResponseEntity<String> saveEmployee(@RequestBody @Valid EmployeeDTO employeeDTO){
        String message = employeeService.saveEmployee(employeeDTO);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping(value = "/findByNameOrCity")
    public ResponseEntity<List<Employee>> findByNameOrCity(@RequestBody EmployeeDTO employeeDTO) {
       return new ResponseEntity<>(employeeService.findByNameOrCity(employeeDTO.getName(), employeeDTO.getCity()), HttpStatus.OK);
    }

    @PutMapping(value = "/updateCityByName")
    public ResponseEntity<Integer> updateCityByName(@RequestBody EmployeeDTO employeeDTO ) {
        return new ResponseEntity<>(employeeService.updateCityByName(employeeDTO.getName(), employeeDTO.getCity()), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteEmployeeById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }

}
