package com.example.bookstoreproject.repositories;

import com.example.bookstoreproject.entity.BillEntity;
import com.example.bookstoreproject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BillRepository extends JpaRepository<BillEntity, Long> {

    @Query("SELECT u FROM BillEntity u WHERE u.userEntity = :userEntity and u.totalMoney = :total and u.checked=false")
    Optional<BillEntity> findByUserEntityAndTotalMoney(UserEntity userEntity, double total);


}
