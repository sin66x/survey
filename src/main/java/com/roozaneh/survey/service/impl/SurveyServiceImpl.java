package com.roozaneh.survey.service.impl;

import com.roozaneh.survey.domain.Survey;
import com.roozaneh.survey.repository.SurveyRepository;
import com.roozaneh.survey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    SurveyRepository surveyRepository;

    @Override
    public Survey findByTitle(String title) {
        return surveyRepository.findByTitle(title);
    }

    @Override
    public Survey findById(int surveyId) {
        if (surveyRepository.findById(surveyId).isPresent())
            return surveyRepository.findById(surveyId).get();
        else
            return null;
    }

    @Override
    public boolean hasAccess(Survey survey) {
        if (survey.getStartTime().before(new Date()) || survey.getEndTime().after(new Date()))
            return false;
        //TODO: user access to survey should be checked here

        return true;
    }


}
