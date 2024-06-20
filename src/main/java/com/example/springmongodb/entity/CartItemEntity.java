package com.example.springmongodb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "CartItem")
public class CartItemEntity extends BaseEntity{

    private ProductEntity product;

    private CartEntity cart;

    @Field("quantity")
    private Integer quantity;

    @Field("totalPrice")
    private Float totalPrice;

    @Field("createTime")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date createTime;

    @Field("updateTime")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date updateTime;
}
