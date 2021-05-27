package com.example.bookstoreproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstoreproject.entity.BillDetailEntity;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetailEntity, Long> {

}
