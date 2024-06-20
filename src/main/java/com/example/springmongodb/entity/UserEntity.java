package com.example.springmongodb.entity;

import com.example.springmongodb.utils.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "User")
public class UserEntity {

    @Field("firstName")
    private String firstName;

    @Field("lastName")
    private String lastName;

    @Transient
    private String fullName = this.firstName+" "+this.lastName;

    @Field("username")
    @Indexed(unique = true)
    private String username;

    @Field("email")
    @Indexed(unique = true)
    private String email;

    @Field("password")
    private String password;

    @Field("phoneNumber")
    @Indexed(unique = true)
    private String phoneNumber;

    @Field("status")
    private UserStatus status;

    @Field("isActive")
    private Boolean isActive;

    private Set<RoleEntity> roles;

    @Field("createTime")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date createTime;

    @Field("updateTime")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date updateTime;
}
