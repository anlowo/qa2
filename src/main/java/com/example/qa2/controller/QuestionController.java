package com.example.qa2.controller;

import com.example.qa2.entity.Question;
import com.example.qa2.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("/new")
    public ResponseEntity<?> addQuestion(@RequestParam String questionText, @RequestParam Long questionnaireId) {
        Question question = questionService.createQuestion(questionText, questionnaireId);
        return ResponseEntity.ok(question);
    }

    @GetMapping("/id")
    public ResponseEntity<?> getQuestionById(@PathVariable Long id, @RequestParam String questionText) {
        Question question = questionService.updateQuestion(id, questionText);
        return ResponseEntity.ok(question);
    }

    @GetMapping("/get_all")
    public List<Question> getAllQuestion() {
        return questionService.readAllQuestion();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editQuestion(@PathVariable Long id, @RequestParam String questionText) {
        Question question = questionService.updateQuestion(id, questionText);
        return ResponseEntity.ok(question);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long id) {
        Question question = questionService.deleteQuestion(id);
        return ResponseEntity.ok(question);
    }
}
