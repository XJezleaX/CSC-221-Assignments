package com.example.assignment5backend.controller;

import com.example.assignment5backend.model.User;
import com.example.assignment5backend.service.LoginService;
import com.example.assignment5backend.service.impl.LoginServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class LoginController {


    private final LoginService loginService;

    public LoginController(LoginServiceImpl loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public User login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return loginService.login(username, password);
    }

    @PostMapping("/logout")
    public boolean logout(@RequestBody User user){
        return true;
    }
}