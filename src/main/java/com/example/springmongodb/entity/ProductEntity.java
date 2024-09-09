package com.example.springmongodb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "Product")
public class ProductEntity extends BaseEntity{

    @Field("name")
    @Indexed(unique = true)
    private String name;

    @Field("description")
    private String description;

    @Field("image")
    private String image;

    @Field("extraImage1")
    private String extraImage1;

    @Field("extraImage2")
    private String extraImage2;

    @Field("price")
    private Float price;

    @Field("buyingCount")
    private Integer buyingCount;

    @Field("quantity")
    private Integer quantity;

    @Field("status")
    private String status;

    @Field("createTime")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private ZonedDateTime createTime;

    @Field("updateTime")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private ZonedDateTime updateTime;

    private CategoryEntity category;
}
