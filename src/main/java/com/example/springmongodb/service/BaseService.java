package com.example.springmongodb.service;

import com.example.springmongodb.entity.ProductEntity;
import com.example.springmongodb.exception.UnSuccessException;
import com.example.springmongodb.model.request.SearchRequest;
import com.example.springmongodb.model.response.ResponseObject;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface BaseService<T>{

    void createAll(List<T> ts);

    T getById(String id) throws UnSuccessException;

    T create(T t);

    T update(String id, T t);

    void delete(String id);

    Page<T> search(SearchRequest req) throws UnsupportedEncodingException;

    List<T> getByIds(List<String> ids);
}
