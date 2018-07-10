package com.example.daltoncollage.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Department {
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;




    @OneToMany (mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Instructor>instructors;

    public Set<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(Set<Instructor> instructors) {
        this.instructors = instructors;
    }

    @OneToMany(mappedBy = "department",
    cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Major>majors;

    public Set<Major> getMajors() {
        return majors;
    }

    public void setMajors(Set<Major> majors) {
        this.majors = majors;
    }
}
