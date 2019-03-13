package com.spring.one.Springdemoproject.repository;

import com.spring.one.Springdemoproject.models.Names;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface NamesRepository extends MongoRepository<Names, String> {

    @Override
    List<Names> findAll();

    @Override
    Optional<Names> findById(String id);

    @Override
    Names save(Names names);

    @Override
    void deleteById (String id);

}

