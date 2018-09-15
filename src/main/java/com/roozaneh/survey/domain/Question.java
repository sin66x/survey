package com.roozaneh.survey.domain;

import javafx.scene.control.Tab;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 9/14/18
 * Time: 2:11 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="questions")
public class Question {
    private int id;
    private String text;
    private String type;
    private SurveyPart surveyPart;

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    @Column(name = "ID",unique = true,nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(name="type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @ManyToOne
    @JoinColumn(name="survey_part_id")
    public SurveyPart getSurveyPart() {
        return surveyPart;
    }

    public void setSurveyPart(SurveyPart surveyPart) {
        this.surveyPart = surveyPart;
    }
}
