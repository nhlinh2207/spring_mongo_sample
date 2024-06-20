package com.example.springmongodb.service.impl;

import com.example.springmongodb.entity.ProductEntity;
import com.example.springmongodb.exception.UnSuccessException;
import com.example.springmongodb.model.response.ResponseObject;
import com.example.springmongodb.model.response.ResponseStatus;
import com.example.springmongodb.repo.BaseRepo;
import com.example.springmongodb.repo.CategoryRepo;
import com.example.springmongodb.repo.ProductRepo;
import com.example.springmongodb.service.IProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
@AllArgsConstructor
public class ProductService extends BaseServiceImpl<ProductEntity> implements IProductService {

    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    @Override
    protected BaseRepo<ProductEntity> getBaseRepo() {
        return productRepo;
    }

    @Override
    public ProductEntity create(ProductEntity productEntity) {
        productEntity.setCreateTime(new Date());
        productEntity.setUpdateTime(new Date());
        productEntity.setCategory(categoryRepo.findById(productEntity.getCategory().getId())
                .orElseThrow(() -> new UnSuccessException("Can not find Category By Id")));
        return super.create(productEntity);
    }

    @Override
    public ProductEntity update(String id, ProductEntity productEntity) {
        productEntity.setUpdateTime(new Date());
        if (productEntity.getCategory() != null){
            productEntity.setCategory(categoryRepo.findById(productEntity.getCategory().getId())
                    .orElseThrow(() -> new UnSuccessException("Can not find Category By Id")));
        }
        return super.update(id, productEntity);
    }

    @Override
    public ResponseObject<Page<ProductEntity>> findAll(JSONObject request) {
        try{
            SimpleDateFormat smf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            ResponseObject<Page<ProductEntity>> response = new ResponseObject<>(true, ResponseStatus.DO_SERVICE_SUCCESSFUL);
            Sort.Direction direction = request.get("sortDir").toString().equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
            Pageable pageable = PageRequest.of(
                    Integer.parseInt(request.get("page").toString()),
                    Integer.parseInt(request.get("size").toString()),
                    Sort.by(direction, request.get("sortBy").toString()));
            Page<ProductEntity> page = productRepo.findByConditions(
                    request.get("name").toString(),
                    request.get("categoryId").toString(),
                    smf.parse(request.get("from").toString()),
                    smf.parse(request.get("to").toString()),
                    pageable
            );
            response.setData(page);
            return response;
        }catch (Exception e){
            e.printStackTrace();
            throw new UnSuccessException(e.getMessage());
        }
    }
}
