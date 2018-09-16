package com.roozaneh.survey.service;

import com.roozaneh.survey.domain.Survey;

public interface SurveyService {
    public Survey findByTitle(String title);
    Survey findById(int surveyId);

    boolean hasAccess(Survey survey);
}
