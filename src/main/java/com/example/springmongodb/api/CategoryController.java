package com.example.springmongodb.api;

import com.example.springmongodb.entity.CategoryEntity;
import com.example.springmongodb.model.response.ResponseObject;
import com.example.springmongodb.model.response.ResponseStatus;
import com.example.springmongodb.service.BaseService;
import com.example.springmongodb.service.ICategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
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

    @PostMapping(path = "/createWithoutEntity")
    public ResponseEntity<?> create(@RequestBody JSONObject request){
        ResponseObject<Object> response = new ResponseObject<>(true, ResponseStatus.DO_SERVICE_SUCCESSFUL);
        response.setData(categoryService.createWithoutEntity(request));
        return ResponseEntity.ok(response);
    }

}
