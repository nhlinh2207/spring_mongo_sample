package com.example.springmongodb.service;

import com.example.springmongodb.entity.ProductEntity;
import com.example.springmongodb.model.response.ResponseObject;
import org.json.simple.JSONObject;
import org.springframework.data.domain.Page;

public interface IProductService extends BaseService<ProductEntity> {

    ResponseObject<Page<ProductEntity>> findAll(JSONObject request);
}
