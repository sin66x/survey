package com.roozaneh.survey.controller;

import com.roozaneh.survey.domain.charts.PartRate;
import com.roozaneh.survey.domain.charts.QuestionRate;
import com.roozaneh.survey.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ChartController {
    @Autowired
    ChartService chartService;

    @RequestMapping(value = "/question-rate", method = RequestMethod.GET)
    public @ResponseBody
    List<QuestionRate> questionRate() {
        List<QuestionRate> questionRates = chartService.questionRate();

        return questionRates;
    }
    @RequestMapping(value = "/part-rate", method = RequestMethod.GET)
    public @ResponseBody
    List<PartRate> partRate() {
        return chartService.partRate();
    }

    @RequestMapping(value = "/charts", method = RequestMethod.GET)
    public String questionRateLoadView()
    {
        return "charts/questionRate";
    }
}
