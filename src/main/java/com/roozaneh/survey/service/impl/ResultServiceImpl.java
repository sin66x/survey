package com.roozaneh.survey.service.impl;

import com.roozaneh.survey.domain.Result;
import com.roozaneh.survey.domain.Survey;
import com.roozaneh.survey.domain.User;
import com.roozaneh.survey.domain.UserSurvey;
import com.roozaneh.survey.model.AnswerModel;
import com.roozaneh.survey.repository.ResultRepository;
import com.roozaneh.survey.service.QuestionService;
import com.roozaneh.survey.service.ResultService;
import com.roozaneh.survey.service.SurveyService;
import com.roozaneh.survey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    ResultRepository resultRepository;

    @Autowired
    QuestionService questionService;

    @Autowired
    UserService userService;

    @Autowired
    SurveyService surveyService;

    @Override
    public void save(Result result) {
        resultRepository.save(result);
    }

    @Override
    public void save(List<AnswerModel> answers) {
        for (AnswerModel answerModel : answers) {
            Result result = new Result();
            result.setAnswer(answerModel.getAnswer());
            result.setCreatedDate(new Date());
            result.setQuestion(questionService.findById(answerModel.getQuestionId()));

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username= authentication.getName();
            result.setUser(userService.findByUsername(username));

            save(result);
        }
    }

    @Override
    public boolean isVoted(int surveyId) {
        Survey survey = surveyService.findById(surveyId);
        return isVoted(survey);

    }

    @Override
    public boolean isVoted(Survey survey) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username= authentication.getName();
        User user = userService.findByUsername(username);
        List<Result> results = resultRepository.findByUserAndSurvey(user,survey);
        if (results!=null && results.size()>0)
            return true;
        return false;

    }

    @Override
    public boolean isExpired(Survey survey) {
        return survey.getEndTime().before(new Date());
    }

    @Override
    public boolean isNotYet(Survey survey) {
        return survey.getStartTime().after(new Date());
    }

    @Override
    public List<Result> findAll() {
        return resultRepository.findAll();
    }

    @Override
    public List<Result> findAllTextAnswers() {
        return resultRepository.findAllTextAnswers();
    }
}
