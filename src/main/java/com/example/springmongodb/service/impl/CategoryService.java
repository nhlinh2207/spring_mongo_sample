package com.example.springmongodb.service.impl;

import com.example.springmongodb.entity.CategoryEntity;
import com.example.springmongodb.model.response.ResponseObject;
import com.example.springmongodb.model.response.ResponseStatus;
import com.example.springmongodb.repo.BaseRepo;
import com.example.springmongodb.repo.CategoryRepo;
import com.example.springmongodb.service.ICategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CategoryService extends BaseServiceImpl<CategoryEntity> implements ICategoryService {

    private final CategoryRepo categoryRepo;

    @Override
    protected BaseRepo<CategoryEntity> getBaseRepo() {
        return categoryRepo;
    }

    @Override
    protected Class<CategoryEntity> getEntityClass() {
        return CategoryEntity.class;
    }

    @Override
    public ResponseObject<String> createWithoutEntity(JSONObject request) {
        ResponseObject<String> response  = new ResponseObject<>(true, ResponseStatus.DO_SERVICE_SUCCESSFUL);
        JSONObject result = mongoTemplate.insert(request, "TestCollection");
        System.out.println("_id = "+result.get("_id").toString());
        response.setData(result.get("_id").toString());
        return response;
    }
}
