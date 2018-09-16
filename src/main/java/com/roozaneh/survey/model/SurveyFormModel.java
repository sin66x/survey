package com.roozaneh.survey.model;

import java.util.List;

public class SurveyFormModel {
    List<AnswerModel> answers;

    public List<AnswerModel> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerModel> answers) {
        this.answers = answers;
    }
}
