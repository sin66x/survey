package com.roozaneh.survey.controller;


import com.roozaneh.survey.config.messageloader.Messages;
import com.roozaneh.survey.domain.Result;
import com.roozaneh.survey.domain.Survey;
import com.roozaneh.survey.model.AnswerModel;
import com.roozaneh.survey.model.SurveyFormModel;
import com.roozaneh.survey.service.QuestionService;
import com.roozaneh.survey.service.ResultService;
import com.roozaneh.survey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class SurveyController
{
    @Autowired
    SurveyService surveyService;

    @Autowired
    QuestionService questionService;

    @Autowired
    ResultService resultService;

    @RequestMapping(value = "/surveys", method = RequestMethod.GET)
    public String index(Model model, @RequestParam(name = "lang", required = false, defaultValue = "en") String lang)
    {
        List<Survey> surveys = surveyService.findAllActive();
        model.addAttribute("surveys", surveys);
        model.addAttribute("messages", Messages.inst);
        model.addAttribute("lang", lang);

        return "surveys";
    }

    @RequestMapping(value = "/survey", method = RequestMethod.GET)
    public String loadPage(Model model, @RequestParam("sid") int surveyId, @RequestParam(name = "lang", required = false, defaultValue = "en") String lang)
    {
        Survey survey = surveyService.findById(surveyId);
        model.addAttribute("survey", survey);

        SurveyFormModel answerList = new SurveyFormModel();
        model.addAttribute("answerList", answerList);

        model.addAttribute("messages", Messages.inst);
        model.addAttribute("lang", lang);

        //TODO: Check Access
//        if (surveyService.hasAccess(survey))
//        {}
//        else
//        {}

        return "survey";
    }

    @RequestMapping(value = "/survey", method = RequestMethod.POST)
    public String save(@ModelAttribute("answerList") SurveyFormModel formResponse, @RequestParam("sid") int surveyId)
    {
        //TODO: Check Access

        for (AnswerModel answerModel : formResponse.getAnswers()) {
            Result result = new Result();
            result.setAnswer(answerModel.getAnswer());
            result.setCreatedDate(new Date());
            result.setQuestion(questionService.findById(answerModel.getQuestionId()));
            //TODO: set user
            //result.setUser();

            resultService.save(result);
        }

        return "redirect:surveys";
    }

}
