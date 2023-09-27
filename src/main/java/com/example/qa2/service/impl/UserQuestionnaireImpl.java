package com.example.qa2.service.impl;

import com.example.qa2.entity.Questionnaire;
import com.example.qa2.entity.User;
import com.example.qa2.entity.UserQuestionnaire;
import com.example.qa2.repository.QuestionnaireRepository;
import com.example.qa2.repository.UserQuestionnaireRepository;
import com.example.qa2.repository.UserRepository;
import com.example.qa2.service.UserQuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQuestionnaireImpl implements UserQuestionnaireService {
    @Autowired
    private UserQuestionnaireRepository userQuestionnaireRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @Override
    public UserQuestionnaire createUserQuestionnaire(Long userId, Long questionnaireId) {
        UserQuestionnaire userQuestionnaire = new UserQuestionnaire();
        User user = userRepository
                .findById(userId).orElseThrow(() -> new RuntimeException("Ответ с id " + userId + " не найден"));

        Questionnaire questionnaire = questionnaireRepository.
                findById(questionnaireId).orElseThrow(() -> new RuntimeException("Ответ с id " + questionnaireId + " не найден"));

        userQuestionnaire.setUser(user);
        userQuestionnaire.setQuestionnaire(questionnaire);

        userQuestionnaireRepository.save(userQuestionnaire);

        return userQuestionnaire;
    }

    @Override
    public List<UserQuestionnaire> getAllQuestionnaireByUser(Long userId) {
        User user =  userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Ответ с id " + userId + " не найден"));

        return  userQuestionnaireRepository.findAllByUser(user);
    }

    @Override
    public UserQuestionnaire readQuestionnaireById(Long id) {
        return userQuestionnaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ответ с id " + id + " не найден"));
    }
}
