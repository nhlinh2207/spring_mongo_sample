package com.example.springmongodb.service;

import com.example.springmongodb.entity.CategoryEntity;
import com.example.springmongodb.model.response.ResponseObject;
import org.json.simple.JSONObject;

public interface ICategoryService extends BaseService<CategoryEntity>{
    ResponseObject<String> createWithoutEntity(JSONObject request);
}
