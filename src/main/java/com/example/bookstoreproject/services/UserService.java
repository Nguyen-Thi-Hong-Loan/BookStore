package com.example.bookstoreproject.services;

import com.example.bookstoreproject.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public interface UserService extends UserDetailsService {

    UserEntity save(UserEntity userEntity);

    UserEntity findByEmail(String email);

    UserEntity findById(Long id);

    List<UserEntity> findAll();

    boolean verify(String verificationCode);


    void updateResetPasswordToken(String token, String email) throws Exception;

    UserEntity getByResetPasswordToken(String token);

    void sendMail(String email, String resetPasswordLink) throws UnsupportedEncodingException, MessagingException;


    void updatePassword(UserEntity userEntity, String newPassword);

    void sendVerificationEmail(UserEntity entity, String siteURL) throws MessagingException, UnsupportedEncodingException;
}
