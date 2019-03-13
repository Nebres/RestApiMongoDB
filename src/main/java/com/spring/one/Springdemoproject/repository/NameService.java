package com.spring.one.Springdemoproject.repository;

import com.spring.one.Springdemoproject.models.Names;

import java.util.List;

public interface NameService {

    boolean create(Names names);
    boolean deleteById(String id);
    List<Names> findAll();
    Names findById(String id);
    boolean update(Names names, String id);

}
