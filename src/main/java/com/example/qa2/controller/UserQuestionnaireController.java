package com.example.qa2.controller;

import com.example.qa2.entity.Questionnaire;
import com.example.qa2.entity.User;
import com.example.qa2.entity.UserQuestionnaire;
import com.example.qa2.service.UserQuestionnaireService;
import com.example.qa2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user_questionnaire")
public class UserQuestionnaireController {
    @Autowired
    private UserQuestionnaireService userQuestionnaireService;
    @Autowired
    private UserService userService;

    @PostMapping("/new")
    public ResponseEntity<?> addUserQuestionnaire(@RequestParam Long userId, @RequestParam Long answerId) {
        UserQuestionnaire userQuestionnaire = userQuestionnaireService.createUserQuestionnaire(userId, answerId);
        return ResponseEntity.ok(userQuestionnaire);
    }

    @GetMapping("/users/{id}")
    public List<UserQuestionnaire> getUserQuestionnaireByUser(@PathVariable Long id) {
        return userQuestionnaireService.getAllQuestionnaireByUser(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserQuestionnaireById(@PathVariable Long id) {
        UserQuestionnaire userQuestionnaire = userQuestionnaireService.readQuestionnaireById(id);
        return ResponseEntity.ok(userQuestionnaire);
    }
}
