package com.example.springmongodb.repo;

import com.example.springmongodb.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface ProductRepo extends BaseRepo<ProductEntity>{

    @Query("{'name' : { $regex: ?0, $options: 'i' }, 'category.id' : ?1, 'createTime' : {$gte : ?2, $lte : ?3} }")
    Page<ProductEntity> findByConditions(String name,
                                         String categoryId,
                                         Date from,
                                         Date to,
                                         Pageable pageable);

    List<ProductEntity> findByCategoryId(String id);


}
