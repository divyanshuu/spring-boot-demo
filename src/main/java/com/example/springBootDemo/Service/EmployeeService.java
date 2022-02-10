package com.example.springBootDemo.Service;

import com.example.springBootDemo.dtos.EmployeeDTO;
import com.example.springBootDemo.model.Department;
import com.example.springBootDemo.model.Employee;
import com.example.springBootDemo.repository.DepartmentRepository;
import com.example.springBootDemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        //System.out.println("Employees Fetched " + employees);
        return  employees;
    }

    public Employee getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        else {
            return null;
        }
    }
    public String saveEmployee(EmployeeDTO employeeDTO) {
        Department department = new Department(1, "COmputer", "Delhi");
        department= departmentRepository.save(department);
        Employee employee = new Employee(employeeDTO.getId(), employeeDTO.getName(), employeeDTO.getCity(), department);
        employeeRepository.save(employee);
        return "Employee Saved successfully";
    }

    public List<Employee> findByNameOrCity(String name, String city) {
        return employeeRepository.findByNameOrCity(name, city);
    }

    @Transactional
    public Integer updateCityByName(String name, String city) {
        return employeeRepository.updateCityByName(name, city);
    }

    @Transactional
    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
    }

}
