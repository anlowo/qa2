package com.example.qa2.controller;

import com.example.qa2.entity.Answer;
import com.example.qa2.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @PostMapping("/new")
    public ResponseEntity<?> addAnswer(@RequestParam String answerText, @RequestParam Long questionId) {
        Answer answer = answerService.createAnswer(answerText, questionId);
        return ResponseEntity.ok(answer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAnswerById(@PathVariable Long id) {
        Answer answer = answerService.readAnswer(id);
        return ResponseEntity.ok(answer);
    }

    @GetMapping("getall")
    public List<Answer> getAllAnswers() {
        return answerService.readAllAnswer();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editAnswer(@PathVariable Long id, String answerText) {
        Answer answer = answerService.updateAnswer(id, answerText);
        return ResponseEntity.ok(answer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnswer(@PathVariable Long id) {
        Answer answer = answerService.deleteAnswer(id);
        return ResponseEntity.ok(answer);
    }
}
