package com.roozaneh.survey.domain;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 9/14/18
 * Time: 1:47 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="user_survey")
public class UserSurvey {
    private int id;
    private User user;
    private Survey survey;

    @ManyToOne
    @JoinColumn(name="survey_id")
    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }
    @ManyToOne
    @JoinColumn(name="user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    @Column(name = "ID",unique = true,nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
