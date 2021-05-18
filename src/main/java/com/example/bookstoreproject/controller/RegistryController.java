package com.example.bookstoreproject.controller;


import com.example.bookstoreproject.dto.Utility;
import com.example.bookstoreproject.entity.RoleEntity;
import com.example.bookstoreproject.entity.UserEntity;
import com.example.bookstoreproject.services.RoleService;
import com.example.bookstoreproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

@Controller
@RequestMapping("/bookstore")
public class RegistryController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Autowired
    private JavaMailSender mailSender;


    @GetMapping("register")
    public String register(Model model) {

        model.addAttribute("user", new UserEntity());
        return "registry";
    }


    @PostMapping("registerNow")
    public String registerUserAccount(@ModelAttribute("user") UserEntity entity, HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {

        RoleEntity roleEntity = roleService.findByRoleName("ROLE_USER");

        entity.setRoles(Arrays.asList(roleEntity));
        userService.save(entity);

        String siteURL = Utility.getSiteURL(request);
        userService.sendVerificationEmail(entity, siteURL);

        return "redirect:/bookstore/register?success";
    }


    @GetMapping("/verify")
    public String verifyAccount(@Param("code") String code, Model model) {
        boolean verified = userService.verify(code);

        String pageTitle = verified ? "Verified Succeed!" : "Verification code";
        model.addAttribute("pageTitle", pageTitle);

        return verified ? "verifySuccess" : "verifyFail";


    }

    @PostMapping("/checkEmail")
    @ResponseBody
    public String check(@RequestParam String email) {
        return (userService.findByEmail(email) != null ? "exist" : "ok");
    }
}
