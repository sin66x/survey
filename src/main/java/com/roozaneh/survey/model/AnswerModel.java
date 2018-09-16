package com.roozaneh.survey.model;

public class AnswerModel {
    String questionTitle;
    String questionId;
    String answer;

    public AnswerModel(){}

    public AnswerModel(String questionTitle, String answer) {
        this.questionTitle = questionTitle;
        this.answer = answer;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "AnswerModel{" +
                "questionTitle='" + questionTitle + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
