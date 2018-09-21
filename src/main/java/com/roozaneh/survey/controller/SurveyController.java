package com.roozaneh.survey.controller;


import com.roozaneh.survey.config.messageloader.Messages;
import com.roozaneh.survey.domain.Result;
import com.roozaneh.survey.domain.Survey;
import com.roozaneh.survey.model.AnswerModel;
import com.roozaneh.survey.model.SurveyFormModel;
import com.roozaneh.survey.service.QuestionService;
import com.roozaneh.survey.service.ResultService;
import com.roozaneh.survey.service.SurveyService;
import com.roozaneh.survey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class SurveyController {
    @Autowired
    SurveyService surveyService;

    @Autowired
    ResultService resultService;


    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/surveys", method = RequestMethod.GET)
    public String index(Model model, @RequestParam(name = "lang", required = false, defaultValue = "en") String lang)
    {
        List<Survey> surveys = surveyService.findByUser();
        model.addAttribute("surveys", surveys);
        model.addAttribute("messages", Messages.inst);
        model.addAttribute("lang", lang);

        return "surveys";
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/survey", method = RequestMethod.GET)
    public String loadPage(Model model, @RequestParam("sid") int surveyId, @RequestParam(name = "lang", required = false, defaultValue = "en") String lang) {
        Survey survey = surveyService.findById(surveyId);
        if (resultService.isVoted(survey)||resultService.isExpired(survey)||resultService.isNotYet(survey))
            return "redirect:surveys";

        model.addAttribute("survey", survey);

        SurveyFormModel answerList = new SurveyFormModel();
        model.addAttribute("answerList", answerList);

        model.addAttribute("messages", Messages.inst);
        model.addAttribute("lang", lang);

        if (surveyService.hasAccess(survey))
            return "survey";
        else
            return "surveys";

    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/survey", method = RequestMethod.POST)
    public String save(@ModelAttribute("answerList") SurveyFormModel formResponse, @RequestParam("sid") int surveyId)
    {
        if (surveyService.hasAccess(surveyId) && !resultService.isVoted(surveyId))
            resultService.save(formResponse.getAnswers());


        return "redirect:surveys";
    }

    @RequestMapping(value = "/survey/{id}/results", method = RequestMethod.GET)
    public String results(Model model, @PathVariable("id") Optional<String> surveyId) {
        if (!surveyId.isPresent()) {
            //ToDo:add404
            System.out.println("not found sid...............");
        }
        List<Result> results = resultService.findAllTextAnswers();
        model.addAttribute("results", results);

        return "survey/results";
    }

}
