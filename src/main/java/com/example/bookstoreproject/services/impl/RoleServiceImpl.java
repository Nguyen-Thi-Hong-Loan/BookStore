package com.example.bookstoreproject.services.impl;

import com.example.bookstoreproject.entity.RoleEntity;
import com.example.bookstoreproject.repositories.RoleRepository;
import com.example.bookstoreproject.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleEntity findByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName).orElse(null);
    }

}
