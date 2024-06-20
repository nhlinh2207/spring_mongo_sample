package com.example.springmongodb.service.impl;

import com.example.springmongodb.entity.CategoryEntity;
import com.example.springmongodb.repo.BaseRepo;
import com.example.springmongodb.repo.CategoryRepo;
import com.example.springmongodb.service.ICategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
}
