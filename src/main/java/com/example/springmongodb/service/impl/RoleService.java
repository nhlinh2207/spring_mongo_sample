package com.example.springmongodb.service.impl;

import com.example.springmongodb.entity.RoleEntity;
import com.example.springmongodb.repo.BaseRepo;
import com.example.springmongodb.repo.RoleRepo;
import com.example.springmongodb.service.IRoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Slf4j
@Service
public class RoleService extends BaseServiceImpl<RoleEntity> implements IRoleService {

    private final RoleRepo roleRepo;

    @Override
    protected BaseRepo<RoleEntity> getBaseRepo() {
        return roleRepo;
    }

    @Override
    protected Class<RoleEntity> getEntityClass() {
        return RoleEntity.class;
    }
}
