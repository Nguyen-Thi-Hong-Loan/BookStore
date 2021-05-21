package com.example.bookstoreproject.services.impl;

import com.example.bookstoreproject.entity.BillEntity;
import com.example.bookstoreproject.entity.UserEntity;
import com.example.bookstoreproject.repositories.BillRepository;
import com.example.bookstoreproject.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillEntityServiceImpl implements BillService {
    @Autowired
    BillRepository billRepository;

    @Override
    public BillEntity findByUserEntity(UserEntity userEntity) {
        return billRepository.findByUserEntity(userEntity).orElse(null);
    }

    @Override
    public BillEntity save(BillEntity entity) {
        return billRepository.save(entity);
    }

    @Override
    public List<BillEntity> saveAll(List<BillEntity> entities) {
        return (List<BillEntity>) billRepository.saveAll(entities);
    }

    @Override
    public Optional<BillEntity> findById(Long id) {
        return billRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return billRepository.existsById(id);
    }

    @Override
    public Iterable<BillEntity> findAll() {
        return billRepository.findAll();
    }

    @Override
    public List<BillEntity> findAllById(List<Long> ids) {
        return (List<BillEntity>) billRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return billRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        billRepository.deleteById(id);
    }

    @Override
    public void delete(BillEntity entity) {
        billRepository.delete(entity);
    }

    @Override
    public void deleteAll(List<BillEntity> entities) {
        billRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        billRepository.deleteAll();
    }

}
