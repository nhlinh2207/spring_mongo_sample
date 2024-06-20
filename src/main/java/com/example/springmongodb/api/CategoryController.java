package com.example.springmongodb.api;

import com.example.springmongodb.entity.CategoryEntity;
import com.example.springmongodb.service.BaseService;
import com.example.springmongodb.service.ICategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "category")
@AllArgsConstructor
@Slf4j
public class CategoryController extends BaseController<CategoryEntity>{

    private final ICategoryService categoryService;

    @Override
    protected BaseService<CategoryEntity> getBaseService() {
        return categoryService;
    }

    @Override
    protected Class<CategoryEntity> getEntityClass() {
        return CategoryEntity.class;
    }

}
