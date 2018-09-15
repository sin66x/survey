package com.roozaneh.survey.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SurveyController
{

    @RequestMapping(value = "/survey", method = RequestMethod.GET)
    public String loadPage()
    {
        return "survey";
    }

}
