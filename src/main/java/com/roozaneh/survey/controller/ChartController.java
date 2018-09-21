package com.roozaneh.survey.controller;

import com.roozaneh.survey.config.messageloader.Messages;
import com.roozaneh.survey.domain.charts.PartRate;
import com.roozaneh.survey.domain.charts.QuestionEngagement;
import com.roozaneh.survey.domain.charts.QuestionRate;
import com.roozaneh.survey.service.ChartService;
import com.roozaneh.survey.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ChartController
{
    @Autowired
    ChartService chartService;

    @Autowired
    ResultService resultService;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/question-rate", method = RequestMethod.GET)
    public
    @ResponseBody
    List<QuestionRate> questionRate()
    {
        List<QuestionRate> questionRates = chartService.questionRate();

        return questionRates;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/part-rate", method = RequestMethod.GET)
    public
    @ResponseBody
    List<PartRate> partRate()
    {
        return chartService.partRate();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/question-engagement", method = RequestMethod.GET)
    public
    @ResponseBody
    List<QuestionEngagement> questionEngagement()
    {
        return chartService.questionEngagement();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/charts", method = RequestMethod.GET)
    public String questionRateLoadView(Model model, @RequestParam(name = "lang", required = false, defaultValue = "en") String lang)
    {
        model.addAttribute("textAnswers", resultService.findAllTextAnswers());
        model.addAttribute("messages", Messages.inst);
        model.addAttribute("lang", lang);

        return "charts/questionRate";
    }
}
