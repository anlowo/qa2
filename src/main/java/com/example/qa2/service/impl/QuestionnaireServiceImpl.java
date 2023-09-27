package com.example.qa2.service.impl;

import com.example.qa2.entity.Questionnaire;
import com.example.qa2.entity.enums.Type;
import com.example.qa2.repository.QuestionnaireRepository;
import com.example.qa2.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {
    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    public QuestionnaireRepository getQuestionnaireRepository() {
        return questionnaireRepository;
    }

    @Override
    public Questionnaire createQuestionnaire(String name, Type type) {
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setName(name);
        questionnaire.setType(type);
        questionnaireRepository.save(questionnaire);
        return questionnaire;
    }

    @Override
    public Questionnaire readQuestionnaire(Long id) {
        Questionnaire questionnaire = questionnaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Анкета с id " + id + " не найден"));
        System.out.println(questionnaire.toString());
        return questionnaire;
    }

    @Override
    public List<Questionnaire> readAllQuestionnaire() {
        List<Questionnaire> questionnaires = questionnaireRepository.findAll();
        questionnaires.sort(Comparator.comparingLong(Questionnaire::getId));
        return questionnaires;
    }

    @Override
    public Questionnaire updateQuestionnaire(Long id, String name) {
        Questionnaire questionnaire = questionnaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Анкета с id " + id + " не найден"));
        questionnaire.setName(name);
        questionnaireRepository.save(questionnaire);
        return questionnaire;
    }

    @Override
    public Questionnaire deleteQuestionnaire(Long id) {
        Questionnaire questionnaire = questionnaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Анкета с id " + id + " не найден"));
        questionnaireRepository.delete(questionnaire);
        return questionnaire;
    }
}
