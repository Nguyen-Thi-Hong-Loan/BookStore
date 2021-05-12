package com.example.bookstoreproject.controller;

import com.example.bookstoreproject.entity.RoleEntity;
import com.example.bookstoreproject.entity.UserEntity;
import com.example.bookstoreproject.services.RoleService;
import com.example.bookstoreproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("home")
    public String loginAdmin() {
        return "admin/adminIndex";
    }

    @GetMapping("adminUser")
    public String loginAdminUser(ModelMap model) {
        List<UserEntity> listUser = (List<UserEntity>) userService.findAll();
        model.addAttribute("users", listUser);
        return "admin/adminUserManager";
    }

    @GetMapping("adminFeedback")
    public String loginAdminFeedback() {
        return "admin/adminFeedbackManager";
    }

    @GetMapping("adminUser/formAddUser")
    public String loginAdminFormAdd() {
        return "admin/adminFormAdd";
    }


    @ModelAttribute("user")
    public UserEntity userEntity() {
        return new UserEntity();
    }

    @GetMapping("adminUser/formEditUser")
    public String loginAdminFormEditUser() {
        return "admin/adminFormEditUser";
    }


    @PostMapping("adminUser/formAddUser")
    public String addUserNow(@ModelAttribute("user") UserEntity entity) {
        RoleEntity roleEntity = roleService.findByRoleName("ROLE_ADMIN");
        entity.setRoles(Arrays.asList(roleEntity));
        userService.save(entity, 1);

        return "redirect:/admin/adminUser/formAddUser?success";
    }

    @PostMapping("/checkEmail")
    @ResponseBody
    public String check(@RequestParam String email) {
        return (userService.findByEmail(email) != null ? "exist" : "ok");
    }
}
