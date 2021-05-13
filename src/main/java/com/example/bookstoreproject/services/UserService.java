package com.example.bookstoreproject.services;

import com.example.bookstoreproject.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {

    UserEntity save(UserEntity userEntity);

    UserEntity findByEmail(String email);

    List<UserEntity> findAll();


     void updateResetPasswordToken(String token, String email) throws Exception;
     UserEntity getByResetPasswordToken(String token);
     void updatePassword(UserEntity userEntity, String newPassword);

}
