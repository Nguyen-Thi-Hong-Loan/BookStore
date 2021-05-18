package com.example.bookstoreproject.services;

import com.example.bookstoreproject.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public interface UserService extends UserDetailsService {

    void save(UserEntity userEntity, String siteURL) throws MessagingException, UnsupportedEncodingException;


    @Query("SELECT u FROM UserEntity u WHERE u.enabled = true")
    UserEntity findByEmail(String email);

    List<UserEntity> findAll();

    boolean verify(String verificationCode);


    void updateResetPasswordToken(String token, String email) throws Exception;

    UserEntity getByResetPasswordToken(String token);

    void updatePassword(UserEntity userEntity, String newPassword);

    void sendVerificationEmail(UserEntity entity, String siteURL) throws MessagingException, UnsupportedEncodingException;

    void sendMail(String email, String resetPasswordLink) throws UnsupportedEncodingException, MessagingException;

}
