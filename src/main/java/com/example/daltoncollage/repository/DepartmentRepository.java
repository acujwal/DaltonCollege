package com.example.daltoncollage.repository;

import com.example.daltoncollage.model.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long>{
  /*  long findByName(String name);*/
}
