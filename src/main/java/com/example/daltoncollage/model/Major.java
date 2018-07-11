package com.example.daltoncollage.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany (mappedBy = "major", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Subject> subjects;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;


    @OneToMany (mappedBy = "major",
    cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Student> students;

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
