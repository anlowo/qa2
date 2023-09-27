package com.example.qa2.service;

import com.example.qa2.entity.Question;
import com.example.qa2.entity.Questionnaire;

import java.util.List;

public interface QuestionService {
    Question createQuestion(String questionText, Long questionnaire);

    Question readQuestion(Long id);

    List<Question> readAllQuestion();

    Question updateQuestion(Long id, String questionText);

    Question deleteQuestion(Long id);
}
