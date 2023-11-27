package com.example.assignment5backend.service;

import com.example.assignment5backend.model.User;

public interface LoginService {

    User login(String username, String password);

    String logout(User user);
}