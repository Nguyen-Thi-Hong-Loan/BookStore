package com.example.bookstoreproject.services.impl;

import com.example.bookstoreproject.entity.UserEntity;
import com.example.bookstoreproject.repositories.UserRepository;
import com.example.bookstoreproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserEntity save(UserEntity userEntity, int index) {
        return null;
    }

    @Override
    public UserEntity findByEmail(String email) {
        return null;
    }

    @Override
    public List<UserEntity> findAll() {
        return null;
    }

    @Override
    public void updateResetPasswordToken(String token, String email) throws Exception {

    }

    @Override
    public UserEntity getByResetPasswordToken(String token) {
        return null;
    }

    @Override
    public void updatePassword(UserEntity userEntity, String newPassword) {

    }
//
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        return null;
//    }
}
