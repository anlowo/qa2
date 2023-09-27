package com.example.qa2.service.impl;

import com.example.qa2.entity.Question;
import com.example.qa2.entity.Questionnaire;
import com.example.qa2.repository.QuestionRepository;
import com.example.qa2.repository.QuestionnaireRepository;
import com.example.qa2.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    public QuestionRepository getQuestionRepository() {
        return questionRepository;
    }

    @Override
    public Question createQuestion(String questionText, Long questionnaireId) {
        Question question = new Question();
        Questionnaire questionnaire = questionnaireRepository
                .findById(questionnaireId).orElseThrow();

        question.setQuestionText(questionText);
        question.setQuestionnaire(questionnaire);

        questionRepository.save(question);

        return question;
    }

    @Override
    public Question readQuestion(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Вопрос с id " + id + " не найден"));
        System.out.println(question.toString());
        return question;
    }

    @Override
    public List<Question> readAllQuestion() {
        List<Question> questions = questionRepository.findAll();
        questions.sort(Comparator.comparingLong(Question::getId));
        return questions;
    }

    @Override
    public Question updateQuestion(Long id, String questionText) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Вопрос с id " + id + " не найден"));
        question.setQuestionText(questionText);
        questionRepository.save(question);
        return question;
    }

    @Override
    public Question deleteQuestion(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Вопрос с id " + id + " не найден"));
        questionRepository.delete(question);
        return question;
    }
}
