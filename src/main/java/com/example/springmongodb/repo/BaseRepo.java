package com.example.springmongodb.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepo<T> extends MongoRepository<T, String> {

}
