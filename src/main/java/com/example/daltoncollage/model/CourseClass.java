package com.example.daltoncollage.model;

import javax.persistence.*;

@Entity
public class CourseClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String crn_number;
    private String day;
    private String time;
    private String semester;


    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "instructor_id")
    private Instructor instructor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "course_id")
    private Course course;

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCrn_number() {
        return crn_number;
    }

    public void setCrn_number(String crn_number) {
        this.crn_number = crn_number;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
