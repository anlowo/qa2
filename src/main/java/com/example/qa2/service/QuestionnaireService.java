package com.example.qa2.service;

import com.example.qa2.entity.Questionnaire;
import com.example.qa2.entity.enums.Type;

import java.util.List;

public interface QuestionnaireService {
    Questionnaire createQuestionnaire(String name, Type type);

    Questionnaire readQuestionnaire(Long id);

    List<Questionnaire> readAllQuestionnaire();

    Questionnaire updateQuestionnaire(Long id, String name);

    Questionnaire deleteQuestionnaire(Long id);
}
