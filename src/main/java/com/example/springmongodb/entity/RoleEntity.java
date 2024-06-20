package com.example.springmongodb.entity;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "Role")
public class RoleEntity extends BaseEntity{

    @Field("name")
    @Indexed(unique = true)
    private String name;

}
