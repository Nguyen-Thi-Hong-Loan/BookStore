package com.example.bookstoreproject.services.impl;

import com.example.bookstoreproject.entity.RoleEntity;
import com.example.bookstoreproject.entity.UserEntity;
import com.example.bookstoreproject.repositories.UserRepository;
import com.example.bookstoreproject.services.UserService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender javaMailSender;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserEntity saveReg(UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setCreateDate(new Date());
        String randomStr = RandomString.make(64);
        userEntity.setVerificationCode(randomStr);
        userEntity.setEnabled(false);

        return userRepository.save(userEntity);

    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public void sendVerificationEmail(UserEntity user, String siteURL) throws MessagingException, UnsupportedEncodingException {
        String toAddress = user.getEmail();
        String fromAddress = "it315727@gmail.com";
        String senderName = "BOOK STORE";
        String subject = "Please verify your registration";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "Your company name.";

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", user.getName());
        String verifyURL = siteURL + "/bookstore/verify?code=" + user.getVerificationCode();

        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);

        javaMailSender.send(message);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public UserEntity findByEmailVerify(String email) {
        return userRepository.findByEmailAndEnabledIsTrue(email).orElse(null);
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean verify(String verificationCode) {
        UserEntity userEntity = userRepository.findByVerificationCode(verificationCode).orElse(null);

        if (userEntity == null) {
            return false;
        } else {
            userEntity.setVerificationCode(null);
            userEntity.setEnabled(true);
            userRepository.save(userEntity);
        }

        return true;
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

        return userRepository.findByResetPasswordToken(token).orElse(null);
    }

    @Override
    public void updatePassword(UserEntity userEntity, String newPassword) {
        userEntity.setPassword(passwordEncoder.encode(newPassword));
        userEntity.setResetPasswordToken(null);
        userRepository.save(userEntity);
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


    @Override
    public void sendMail(String email, String resetPasswordLink) throws UnsupportedEncodingException, MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom("contact@gmail.com", "BOOK STORE SUPPORT");
        helper.setTo(email);
        String subject = "Here's the link to reset your password";
        String content = "<p> Hello, </p>"
                + "<p>You have requested to reset your password. </p>" +
                "<p>Click the link below to change your password</p>" +
                " <p><a href=\"" + resetPasswordLink + "\">Change my password</a> </p>" +
                "Ignore this mail if you do remember your password, or you have not made the request.";

        helper.setSubject(subject);
        helper.setText(content, true);
        javaMailSender.send(message);

    }


}
