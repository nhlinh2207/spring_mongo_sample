package com.example.springmongodb.api;

import com.example.springmongodb.entity.ProductEntity;
import com.example.springmongodb.service.BaseService;
import com.example.springmongodb.service.IProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/product")
@AllArgsConstructor
@Slf4j
public class ProductController extends BaseController<ProductEntity>{

    private final IProductService productService;

    @Override
    protected BaseService<ProductEntity> getBaseService() {
        return productService;
    }

    @PostMapping(path = "/findAll")
    public ResponseEntity<?> testFindAll(@RequestBody JSONObject request){
        return ResponseEntity.ok(productService.findAll(request));
    }

}
