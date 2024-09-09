package com.example.springmongodb;

import com.example.springmongodb.entity.CategoryEntity;
import com.example.springmongodb.entity.ProductEntity;
import com.example.springmongodb.utils.enums.CategoryStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.ZonedDateTime;

@SpringBootApplication
public class SpringMongoDbApplication implements CommandLineRunner {

    @Autowired
    private MongoTemplate mongoTemplate;


    public static void main(String[] args) {
        SpringApplication.run(SpringMongoDbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        CategoryEntity categoryEntity = CategoryEntity.builder()
                .name("tes name cate")
                .description("test desc cate")
                .status(CategoryStatus.ACTIVE)
                .build();
        categoryEntity = mongoTemplate.findById(mongoTemplate.insert(categoryEntity).getId(), CategoryEntity.class);

        ProductEntity productEntity = ProductEntity.builder()
                .name("test name product")
                .description("test desc product")
                .image("main image")
                .extraImage1("extra image 1")
                .extraImage2("extra image 2")
                .quantity(100)
                .price(1000.300f)
                .createTime(ZonedDateTime.now())
                .updateTime(ZonedDateTime.now())
                .category(categoryEntity)
                .build();
        productEntity = mongoTemplate.findById(mongoTemplate.insert(productEntity).getId(), ProductEntity.class);
    }
}
