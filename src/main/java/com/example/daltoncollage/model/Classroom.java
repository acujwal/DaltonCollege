package com.example.daltoncollage.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String room_no;
    private String capacity;
    private String building_name;

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    public Set<CourseClass> courseClasses;

    public Set<CourseClass> getCourseClasses() {
        return courseClasses;
    }

    public void setCourseClasses(Set<CourseClass> courseClasses) {
        this.courseClasses = courseClasses;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoom_no() {
        return room_no;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getBuilding_name() {
        return building_name;
    }

    public void setBuilding_name(String building_name) {
        this.building_name = building_name;
    }
}
