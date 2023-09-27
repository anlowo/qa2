package com.example.qa2.service;

import com.example.qa2.entity.Answer;

import java.util.List;

public interface AnswerService {
    Answer createAnswer(String answerText, Long questionId);

    Answer readAnswer(Long id);

    List<Answer> readAllAnswer();

    Answer updateAnswer(Long id, String answerText);

    Answer deleteAnswer(Long id);
}
