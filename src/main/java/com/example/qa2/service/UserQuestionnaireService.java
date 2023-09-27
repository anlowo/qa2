package com.example.qa2.service;

import com.example.qa2.entity.Answer;
import com.example.qa2.entity.Questionnaire;
import com.example.qa2.entity.User;
import com.example.qa2.entity.UserQuestionnaire;

import java.util.List;

public interface UserQuestionnaireService {

    UserQuestionnaire createUserQuestionnaire(Long userId, Long answerId);

    List<UserQuestionnaire> getAllQuestionnaireByUser(Long userId);

    UserQuestionnaire readQuestionnaireById(Long id);
}
