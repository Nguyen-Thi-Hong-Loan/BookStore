package com.example.bookstoreproject.services.impl;

import com.example.bookstoreproject.entity.BillEntity;
import com.example.bookstoreproject.entity.UserEntity;
import com.example.bookstoreproject.repositories.BillRepository;
import com.example.bookstoreproject.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillEntityServiceImpl implements BillService {
    @Autowired
    BillRepository billRepository;

    @Override
    public BillEntity findByUserEntity(UserEntity userEntity) {
        return billRepository.findByUserEntity(userEntity).orElse(null);
    }
}
