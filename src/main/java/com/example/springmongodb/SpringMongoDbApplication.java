package com.example.springmongodb;

import com.example.springmongodb.entity.CategoryEntity;
import com.example.springmongodb.entity.ProductEntity;
import com.example.springmongodb.utils.JsonBuilder;
import com.example.springmongodb.utils.enums.CategoryStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class SpringMongoDbApplication implements CommandLineRunner {

    @Autowired
    private MongoTemplate mongoTemplate;


    public static void main(String[] args) {
        SpringApplication.run(SpringMongoDbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        class
//        CategoryEntity categoryEntity = CategoryEntity.builder()
//                .name("tes name cate")
//                .description("test desc cate")
//                .status(CategoryStatus.ACTIVE)
//                .build();
//        categoryEntity = mongoTemplate.findById(mongoTemplate.insert(categoryEntity).getId(), CategoryEntity.class);
//        System.out.println("Category: "+JsonBuilder.parseString(categoryEntity));
//
////        Student
//        ProductEntity productEntity = ProductEntity.builder()
//                .name("test name product")
//                .description("test desc product")
//                .image("main image")
//                .extraImage1("extra image 1")
//                .extraImage2("extra image 2")
//                .quantity(100)
//                .price(1000.300f)
//                .createTime(new Date())
//                .updateTime(new Date())
//                .category(categoryEntity)
//                .build();
//        productEntity = mongoTemplate.findById(mongoTemplate.insert(productEntity).getId(), ProductEntity.class);
//        System.out.println("Product: "+JsonBuilder.parseString(productEntity));
//
////        Query
        Query query = new Query();
        query.addCriteria(Criteria
                .where("category.id").is("6671c962bb18cb582e6113ac")
                .and("studentCode").is("71043e6a-d3fd-4789-98a2-6cb7010cdadb")
        );
        List<ProductEntity> productEntityList = mongoTemplate.find(query, ProductEntity.class);
        System.out.println("Product Find By Category: "+ JsonBuilder.parseString(productEntityList));

//        // Test
//        String regex = "(==|<=|>=|<|>)";
//        Pattern pattern = Pattern.compile(regex);
//        String input = "category.id==6671c887a8ea1928490357c8";
//        Matcher matcher = pattern.matcher(input);
//
//        if (matcher.find()) {
//            String delimiter = matcher.group(1);
//            String[] parts = input.split(Pattern.quote(delimiter));
//            String[] result = new String[parts.length + 1];
//            System.arraycopy(parts, 0, result, 0, parts.length);
//            result[parts.length] = delimiter;
//        } else {
//           ; // Không tìm thấy ký tự đặc biệt nào
//        }
    }
}
