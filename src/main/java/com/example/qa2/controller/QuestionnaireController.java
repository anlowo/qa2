package com.example.qa2.controller;

import com.example.qa2.entity.Questionnaire;
import com.example.qa2.entity.enums.Type;
import com.example.qa2.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {
    @Autowired
    private QuestionnaireService questionnaireService;

    @PostMapping("/new")
    public ResponseEntity<?> addQuestionnaire(@RequestParam String name, @RequestParam Type type) {
        Questionnaire questionnaire = questionnaireService.createQuestionnaire(name, type);
        return ResponseEntity.ok(questionnaire);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getQuestionnaireById(@PathVariable Long id) {
        Questionnaire questionnaire = questionnaireService.readQuestionnaire(id);
        return ResponseEntity.ok(questionnaire);
    }

    @GetMapping("/get_all")
    public List<Questionnaire> getAllQuestionnaire() {
        return questionnaireService.readAllQuestionnaire();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editQuestionnaire(@PathVariable Long id, @RequestParam String name) {
        Questionnaire questionnaire = questionnaireService.updateQuestionnaire(id, name);
        return ResponseEntity.ok(questionnaire);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuestionnaire(@PathVariable Long id) {
        Questionnaire questionnaire = questionnaireService.deleteQuestionnaire(id);
        return ResponseEntity.ok(questionnaire);
    }
}
