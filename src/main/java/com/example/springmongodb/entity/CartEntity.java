package com.example.springmongodb.entity;

import com.example.springmongodb.utils.enums.OrderStatus;
import com.example.springmongodb.utils.enums.PaymentType;
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
@Document(collection = "Cart")
public class CartEntity extends BaseEntity{

    @Field("receiverName")
    private String receiverName;

    @Field("receiverPhoneNumber")
    private String receiverPhoneNumber;

    @Field("status")
    private OrderStatus status;

    @Field("totalPrice")
    private Float totalPrice;

    @Field("paymentType")
    private PaymentType paymentType;

    @Field("isPaid")
    private Boolean isPaid;

    @Field("isDelivered")
    private Boolean isDelivered;

    @Field("isReceived")
    private Boolean isReceived;

    @Field("paymentTime")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date paymentTime;

    @Field("orderTime")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date orderTime;

    @Field("deliveryTime")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date deliveryTime;

    private UserEntity user;
}
