package com.roozaneh.survey.service.impl;

import com.roozaneh.survey.domain.Survey;
import com.roozaneh.survey.domain.User;
import com.roozaneh.survey.domain.UserSurvey;
import com.roozaneh.survey.repository.SurveyRepository;
import com.roozaneh.survey.repository.UserSurveyRepository;
import com.roozaneh.survey.service.ResultService;
import com.roozaneh.survey.service.SurveyService;
import com.roozaneh.survey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    SurveyRepository surveyRepository;

    @Autowired
    UserService userService;

    @Autowired
    UserSurveyRepository userSurveyRepository;

    @Autowired
    ResultService resultService;

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

    public boolean hasAccess(int surveyId) {
        Optional<Survey> optionalSurvey = surveyRepository.findById(surveyId);
        Survey survey;
        if (optionalSurvey.isPresent())
            survey = optionalSurvey.get();
        else
            return false;

        return hasAccess(survey);
    }

    @Override
    public boolean hasAccess(Survey survey) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.findByUsername(username);

        Date currentDate = new Date();
        if (survey.getStartTime().after(currentDate) || survey.getEndTime().before(currentDate))
            return false;

        UserSurvey userSurvey = userSurveyRepository.findByUserAndSurvey(user, survey);
        if (userSurvey == null)
            return false;

        return true;
    }

    @Override
    public List<Survey> findAll() {
        return surveyRepository.findAll();
    }

    @Override
    public List<Survey> findByUser() {
        List<Survey> surveyList = new ArrayList<Survey>();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.findByUsername(username);
        List<UserSurvey> userSurveys = userSurveyRepository.findByUser(user);
        for (UserSurvey userSurvey : userSurveys) {
            Survey tmpSurvey = userSurvey.getSurvey();
            tmpSurvey.setVoted(resultService.isVoted(tmpSurvey));
            tmpSurvey.setExpired(resultService.isExpired(tmpSurvey));
            tmpSurvey.setNotYet(resultService.isNotYet(tmpSurvey));
            surveyList.add(tmpSurvey);
        }
        return surveyList;
    }

}
