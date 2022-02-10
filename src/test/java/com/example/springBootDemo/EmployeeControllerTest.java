package com.example.springBootDemo;

import com.example.springBootDemo.Service.EmployeeService;
import com.example.springBootDemo.model.Department;
import com.example.springBootDemo.model.Employee;
import com.example.springBootDemo.repository.DepartmentRepository;
import com.example.springBootDemo.repository.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class EmployeeControllerTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    RestTemplate restTemplate;

//    @Afte
//    public void deleteTablesData() {
//        employeeRepository.deleteAll();
//        departmentRepository.deleteAll();
//    }
    @Test
    public void testEmployees() {
        Department department = new Department(1, "Electronics", "Punjab");
        department = departmentRepository.save(department);
        Employee employee = new Employee(13, "Lokesh", "Punjab", department);
        employee = employeeRepository.save(employee);

        Employee employee1 = employeeService.getEmployeeById(employee.getId());
        Assertions.assertThat(employee1).isNotNull();
        Assertions.assertThat(employee1).extracting(Employee::getCity).isEqualTo("Punjab");
        String url = "http://localhost:8080/employee/api/v1/fetch/4";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity(headers);
        Employee res = restTemplate.exchange(url, HttpMethod.GET, entity, Employee.class).getBody();
        Assertions.assertThat(res).isNotNull();

    }
}
