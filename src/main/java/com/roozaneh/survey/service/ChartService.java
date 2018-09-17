package com.roozaneh.survey.service;

import com.roozaneh.survey.domain.charts.PartRate;
import com.roozaneh.survey.domain.charts.QuestionEngagement;
import com.roozaneh.survey.domain.charts.QuestionRate;

import java.util.List;

public interface ChartService {
    List<QuestionRate> questionRate();

    List<PartRate> partRate();

    List<QuestionEngagement> questionEngagement();
}
