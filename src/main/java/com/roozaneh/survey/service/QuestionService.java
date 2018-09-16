package com.roozaneh.survey.service;

import com.roozaneh.survey.domain.Question;
import com.roozaneh.survey.domain.Survey;

public interface QuestionService {

    Question findById(String questionId);
}
