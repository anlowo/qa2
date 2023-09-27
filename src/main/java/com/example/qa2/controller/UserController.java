package com.example.qa2.controller;

import com.example.qa2.entity.User;
import com.example.qa2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/new")
    public ResponseEntity<?> addUser(@RequestParam String name) {
        User user = userService.createUser(name);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        User user = userService.readUser(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/get_all")
    public List<User> getAllUser() {
        return userService.readAllUsers();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editUser(@PathVariable Long id, @RequestParam String name) {
        User user = userService.updateUser(id, name);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        User user = userService.deleteUser(id);
        return ResponseEntity.ok(user);
    }
}
