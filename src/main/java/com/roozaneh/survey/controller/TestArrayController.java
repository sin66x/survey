package com.roozaneh.survey.controller;

import com.roozaneh.survey.domain.User;
import com.roozaneh.survey.model.AnswerModel;
import com.roozaneh.survey.model.SurveyFormModel;
import com.roozaneh.survey.model.TestArrayForm;
import com.roozaneh.survey.model.TestModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestArrayController {

    @RequestMapping(value = "/testarray", method = RequestMethod.GET)
    public String loadPage(Model model) {
        SurveyFormModel answerList = new SurveyFormModel();

        model.addAttribute("answerList",answerList);

        TestArrayForm testArrayForm = new TestArrayForm();
        testArrayForm.getTestModelList().add(new TestModel("Q1"));
        testArrayForm.getTestModelList().add(new TestModel("Q2"));
        testArrayForm.getTestModelList().add(new TestModel("Q3"));
        model.addAttribute("testArrayForm",testArrayForm);

        return "tt2";
    }

    @RequestMapping(value = "/testarray", method = RequestMethod.POST)
    public String post(@ModelAttribute("testModels")SurveyFormModel array) {
        System.out.println(array.getAnswers());
        return "tt2";
    }

}
