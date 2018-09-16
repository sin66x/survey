package com.roozaneh.survey.service.impl;

import com.roozaneh.survey.domain.Question;
import com.roozaneh.survey.repository.QuestionRepository;
import com.roozaneh.survey.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public Question findById(String questionId) {
        Optional<Question> question= questionRepository.findById(Integer.parseInt(questionId));
        if (question.isPresent())
            return question.get();
        else
            return null;
    }
}
