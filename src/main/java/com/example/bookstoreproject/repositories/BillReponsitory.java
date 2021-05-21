package com.example.bookstoreproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstoreproject.entity.BillEntity;

@Repository
public interface BillReponsitory extends CrudRepository<BillEntity, Long> {

}



