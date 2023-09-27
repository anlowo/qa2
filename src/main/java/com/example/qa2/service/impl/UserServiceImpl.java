package com.example.qa2.service.impl;

import com.example.qa2.entity.User;
import com.example.qa2.repository.UserRepository;
import com.example.qa2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(String name) {
        User user = new User();
        user.setName(name);
        userRepository.save(user);
        return user;
    }

    @Override
    public User readUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Пользователь с id " + id + " не найден"));
        System.out.println(user.toString());
        return user;
    }

    @Override
    public List<User> readAllUsers() {
        List<User> users = userRepository.findAll();
        users.sort(Comparator.comparingLong(User::getId));
        return users;
    }

    @Override
    public User updateUser(Long id, String name) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Пользователь с id " + id + " не найден"));
        user.setName(name);
        userRepository.save(user);
        return user;
    }

    @Override
    public User deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Пользователь с id " + id + " не найден"));
        userRepository.delete(user);
        return user;
    }
}
