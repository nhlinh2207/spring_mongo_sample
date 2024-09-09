package com.example.springmongodb.service.impl;

import com.example.springmongodb.entity.UserEntity;
import com.example.springmongodb.repo.BaseRepo;
import com.example.springmongodb.repo.UserRepo;
import com.example.springmongodb.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Slf4j
@Service
public class UserService extends BaseServiceImpl<UserEntity> implements IUserService {

    private final UserRepo userRepo;

    @Override
    protected BaseRepo<UserEntity> getBaseRepo() {
        return userRepo;
    }

    @Override
    protected Class<UserEntity> getEntityClass() {
        return UserEntity.class;
    }
}
