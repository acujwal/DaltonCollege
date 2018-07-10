package com.example.daltoncollage.repository;
import com.example.daltoncollage.model.CourseClass;

import org.springframework.data.repository.CrudRepository;

public interface ClassRepository extends CrudRepository<CourseClass, Long> {
}
