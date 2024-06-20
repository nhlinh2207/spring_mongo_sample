package com.example.springmongodb.api;

import com.example.springmongodb.entity.UserEntity;
import com.example.springmongodb.service.BaseService;
import com.example.springmongodb.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserController extends BaseController<UserEntity> {

    private final IUserService userService;

    @Override
    protected BaseService<UserEntity> getBaseService() {
        return userService;
    }

    @Override
    protected Class<UserEntity> getEntityClass() {
        return UserEntity.class;
    }

    
}
