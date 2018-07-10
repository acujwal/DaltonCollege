package com.example.daltoncollage.repository;

import com.example.daltoncollage.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
