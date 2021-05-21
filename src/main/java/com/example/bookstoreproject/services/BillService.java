package com.example.bookstoreproject.services;

import com.example.bookstoreproject.entity.BillEntity;
import com.example.bookstoreproject.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface BillService {

    BillEntity findByUserEntity(UserEntity userEntity);

}
