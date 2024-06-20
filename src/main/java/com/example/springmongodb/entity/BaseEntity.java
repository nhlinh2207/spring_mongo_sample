package com.example.springmongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Data
public class BaseEntity {

    @Id
    @Field(name = "id", targetType = FieldType.OBJECT_ID)
    private String id;

}
