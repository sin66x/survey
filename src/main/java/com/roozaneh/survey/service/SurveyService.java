package com.roozaneh.survey.service;

import com.roozaneh.survey.domain.Result;
import com.roozaneh.survey.domain.Survey;
import com.roozaneh.survey.domain.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SurveyService {

    Survey findByTitle(String title);

    Survey findById(int surveyId);

    boolean hasAccess(int surveyId);

    boolean hasAccess(Survey survey);

    List<Survey> findAll();

    List<Survey> findByUser();

}
