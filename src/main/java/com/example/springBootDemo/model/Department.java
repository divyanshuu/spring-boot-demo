package com.example.springBootDemo.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = {"employees"})
@Component
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "dept_name")
    private String deptName;
    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Department(int id, String deptName, String location) {
        this.id = id;
        this.deptName = deptName;
        this.location = location;
    }
}
