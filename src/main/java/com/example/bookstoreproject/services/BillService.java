package com.example.bookstoreproject.services;

import com.example.bookstoreproject.entity.BillEntity;
import com.example.bookstoreproject.entity.UserEntity;
import com.example.bookstoreproject.globalData.DataCart;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BillService {

    BillEntity findByUserEntityAndPrice(UserEntity userEntity, double totalPrice);

    void deleteAll();

    void deleteAll(List<BillEntity> entities);

    void delete(BillEntity entity);

    void deleteById(Long id);

    long count();

    List<BillEntity> findAllById(List<Long> ids);

    Iterable<BillEntity> findAll();

    boolean existsById(Long id);

    Optional<BillEntity> findById(Long id);

    List<BillEntity> saveAll(List<BillEntity> entities);

    BillEntity save(BillEntity entity);


}
