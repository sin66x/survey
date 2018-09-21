package com.roozaneh.survey.service;

import com.roozaneh.survey.domain.Result;
import com.roozaneh.survey.domain.Survey;
import com.roozaneh.survey.model.AnswerModel;

import java.util.List;

public interface ResultService
{

    void save(Result result);

    void save(List<AnswerModel> answers);

    boolean isVoted(int surveyId);

    boolean isVoted(Survey survey);

    boolean isExpired(Survey survey);

    boolean isNotYet(Survey survey);

    public List<Result> findAll();

    public List<Result> findAllTextAnswers();
}
