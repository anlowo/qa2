package com.example.qa2.service.impl;

import com.example.qa2.entity.Answer;
import com.example.qa2.entity.Question;
import com.example.qa2.repository.AnswerRepository;
import com.example.qa2.repository.QuestionRepository;
import com.example.qa2.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Answer createAnswer(String answerText, Long questionId) {
        Answer answer = new Answer();
        Question question = questionRepository.findById(questionId).orElseThrow();
        answer.setAnswerText(answerText);
        answer.setQuestion(question);
        answerRepository.save(answer);
        return answer;
    }

    @Override
    public Answer readAnswer(Long id) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ответ с id " + id + " не найден"));
        System.out.println(answer.toString());
        return answer;
    }

    @Override
    public List<Answer> readAllAnswer() {
        List<Answer> answers = answerRepository.findAll();
        answers.sort(Comparator.comparingLong(Answer::getId));
        return answers;
    }

    @Override
    public Answer updateAnswer(Long id, String answerText) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ответ с id " + id + " не найден"));
        answer.setAnswerText(answerText);
        answerRepository.save(answer);
        return answer;
    }

    @Override
    public Answer deleteAnswer(Long id) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ответ с id " + id + " не найден"));
        answerRepository.delete(answer);
        return answer;
    }
}
