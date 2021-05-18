package com.example.bookstoreproject.controller;

import com.example.bookstoreproject.dto.Utility;
import com.example.bookstoreproject.entity.UserEntity;
import com.example.bookstoreproject.services.UserService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/bookstore")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("login")
    public String login() {

        return "login";
    }

    @ModelAttribute("loginUser")
    public UserEntity userEntity() {
        return new UserEntity();
    }

    @GetMapping("forgotPassword")
    public String forgotPassword() {
        return "forgotPassword";
    }

    @GetMapping("logout")
    public String logout() {
        return "home";
    }

    @GetMapping("logoutSuccess")
    public String logoutSuccess() {
        return "home";
    }

    @PostMapping("forgotPassword")
    public String processForgotPassForm(HttpServletRequest request, Model model) {
        String email = request.getParameter("email");
        String token = RandomString.make(45);

        try {
            userService.updateResetPasswordToken(token, email);
            String resetPasswordLink = Utility.getSiteURL(request) + "/bookstore/resetPassword?token=" + token;
            userService.sendMail(email, resetPasswordLink);
            model.addAttribute("mess",
                    "We have sent a reset password link to your email. Please check");

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "forgotPassword";
    }


    @GetMapping("/resetPassword")
    public String showResetPassword(@Param(value = "token") String token, Model model) {

        UserEntity userEntity = userService.getByResetPasswordToken(token);
        if (userEntity == null) {
            model.addAttribute("title", "Reset your password");
            model.addAttribute("mess", "Invalid Token");
            return "mess";
        }
        model.addAttribute("token", token);

        return "resetPasswordForm";
    }

    @PostMapping("/resetPassword")
    public String processResetPassword(HttpServletRequest request, Model model) {
        String token = request.getParameter("token");
        String password = request.getParameter("password");
        UserEntity userEntity = userService.getByResetPasswordToken(token);

        if (userEntity == null) {
            model.addAttribute("title", "Reset your password");
            model.addAttribute("mess", "Invalid Token");
        } else {
            userService.updatePassword(userEntity, password);
            model.addAttribute("mess", "You have success changed your password");
            return "login";
        }

        return "resetPasswordForm";

    }

}
