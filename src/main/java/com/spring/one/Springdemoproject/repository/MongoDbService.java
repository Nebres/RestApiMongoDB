package com.spring.one.Springdemoproject.repository;

import com.spring.one.Springdemoproject.models.Names;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MongoDbService implements NameService{

    @Autowired
    private NamesRepository repository;

    @Override
    public boolean create(Names names) {
        repository.save(names);
        try {
            repository.save(names);
            return true;
        } catch(Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteById(String id) {
        try {
            repository.deleteById(id);
            return true;
        } catch(Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    @Override
    public List<Names> findAll() {
        return Optional.ofNullable(repository.findAll()).orElse(Collections.emptyList());
    }

    @Override
    public Names findById(String id) {
       if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        } else {
            return new Names();
        }
    }

    @Override
    public boolean update(Names names, String id) {

        if (repository.findById(id).isPresent()) {
            Names toUpdate = repository.findById(id).get();
            toUpdate.updateName(names);
            repository.save(toUpdate);
            return true;
        } else {
            return false;
        }
    }

}
