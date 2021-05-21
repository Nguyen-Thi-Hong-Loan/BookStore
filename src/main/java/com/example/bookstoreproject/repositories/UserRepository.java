package com.example.bookstoreproject.repositories;


import com.example.bookstoreproject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findAll();

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByResetPasswordToken(String token);

    Optional<UserEntity> findByVerificationCode(String code);

    Optional<UserEntity> findById(Long id);

}
