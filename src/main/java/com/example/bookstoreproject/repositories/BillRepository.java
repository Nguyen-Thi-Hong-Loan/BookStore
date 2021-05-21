package com.example.bookstoreproject.repositories;

import com.example.bookstoreproject.entity.BillEntity;
import com.example.bookstoreproject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BillRepository extends JpaRepository<BillEntity, Long> {

    Optional<BillEntity> findByUserEntity(UserEntity userEntity);
}
