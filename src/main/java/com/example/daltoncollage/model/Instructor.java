package com.example.daltoncollage.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String employee_no;

    private String name;

    private String office_no;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<CourseClass>courseClasses;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "department_id")
    private Department department;


    public Set<CourseClass> getCourseClasses() {
        return courseClasses;
    }

    public void setCourseClasses(Set<CourseClass> courseClasses) {
        this.courseClasses = courseClasses;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmployee_no() {
        return employee_no;
    }

    public void setEmployee_no(String employee_no) {
        this.employee_no = employee_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOffice_no() {
        return office_no;
    }

    public void setOffice_no(String office_no) {
        this.office_no = office_no;
    }
}

