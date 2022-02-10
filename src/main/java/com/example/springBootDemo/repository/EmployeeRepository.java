package com.example.springBootDemo.repository;

import com.example.springBootDemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    //@Query("select e from Employee e where e.name = ?1 or e.city = ?2")
    @Query("select e from Employee e where e.name = :name or e.city = :city")
    List<Employee> findByNameOrCity(@Param("name") String name, @Param("city") String city);

    @Modifying
    @Query("update Employee e set e.city = :city where e.name = :name")
    Integer updateCityByName(@Param("name") String name, @Param("city") String city);

    @Query("select e from Employee e INNER JOIN e.department where e.name = :name")
    List<Employee> fetchEmployeesWIthDepartment(String name);
}
