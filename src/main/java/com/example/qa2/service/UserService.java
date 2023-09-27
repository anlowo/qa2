package com.example.qa2.service;

import com.example.qa2.entity.User;

import java.util.List;

public interface UserService {
    User createUser(String name);

    User readUser(Long id);

    List<User> readAllUsers();

    User updateUser(Long id, String name);

    User deleteUser(Long id);
}
