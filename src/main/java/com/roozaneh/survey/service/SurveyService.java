package com.roozaneh.survey.service;

import com.roozaneh.survey.domain.Survey;

import java.util.List;

public interface SurveyService {

    public Survey findByTitle(String title);

    Survey findById(int surveyId);

    boolean hasAccess(Survey survey);

    public List<Survey> findAll();

    public List<Survey> findAllActive();

}
