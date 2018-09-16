package com.roozaneh.survey.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 9/14/18
 * Time: 1:57 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="survey_parts")
public class SurveyPart {
    private int id;
    private String title;
    private Survey survey;
    private List<Question> questions;

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    @Column(name = "ID",unique = true,nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne
    @JoinColumn(name="survey_id")
    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    @OneToMany
    @JoinColumn(name = "survey_part_id")
    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
