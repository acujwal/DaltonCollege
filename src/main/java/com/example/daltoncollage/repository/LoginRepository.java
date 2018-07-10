package com.example.daltoncollage.repository;

import com.example.daltoncollage.model.Login;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<Login,Long> {
    long countByUsernameAndPassword(String username, String password);


}
