package com.example.daltoncollage.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String course_no;
    private String name;
    private String description;
    private String credit;




    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<CourseClass> courseClasses;




    @ManyToOne
            (fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    private Subject subject;


    public Set<CourseClass> getCourseClasses() {
        return courseClasses;
    }

    public void setCourseClasses(Set<CourseClass> courseClasses) {
        this.courseClasses = courseClasses;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourse_no() {
        return course_no;
    }

    public void setCourse_no(String course_no) {
        this.course_no = course_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }
}
