package com.example.bookstoreproject.services.impl;

import com.example.bookstoreproject.entity.RoleEntity;
import com.example.bookstoreproject.entity.UserEntity;
import com.example.bookstoreproject.repositories.UserRepository;
import com.example.bookstoreproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserEntity save(UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void updateResetPasswordToken(String token, String email) throws Exception {
        UserEntity user = userRepository.findByEmail(email).orElse(null);
        if (user != null) {
            user.setResetPasswordToken(token);
            userRepository.save(user);
        } else {
            throw new Exception("Could not find any customer with the email " + email);
        }

    }

    @Override
    public UserEntity getByResetPasswordToken(String token) {

        return null;
    }

    @Override
    public void updatePassword(UserEntity userEntity, String newPassword) {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(username).get();
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        User result = new User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
        for (RoleEntity a : user.getRoles()) {
            System.out.println(a.getRoleName());
        }
        return result;
    }

    private List<? extends GrantedAuthority> mapRolesToAuthorities(List<RoleEntity> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName().toString())).collect(Collectors.toList());

    }

}
