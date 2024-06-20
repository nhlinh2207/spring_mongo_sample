package com.example.springmongodb.entity;


import com.example.springmongodb.utils.enums.CategoryStatus;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "Category")
public class CategoryEntity extends BaseEntity{

    @Field("name")
    @Indexed(unique = true)
    private String name;

    @Field("description")
    private String description;

    @Field("status")
    private CategoryStatus status;

}
