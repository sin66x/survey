package com.roozaneh.survey.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 9/14/18
 * Time: 1:36 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="surveys")
public class Survey {

    private int id;
    private String title;
    private Date createdDate;
    private Date startTime;
    private Date endTime;
    private List<SurveyPart> surveyParts;

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    @Column(name = "ID",unique = true,nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name="end_time")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    @Column(name="start_time")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    @Column(name="created_date")
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @OneToMany
    @JoinColumn(name = "survey_id")
    public List<SurveyPart> getSurveyParts() {
        return surveyParts;
    }

    public void setSurveyParts(List<SurveyPart> surveyParts) {
        this.surveyParts = surveyParts;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createdDate=" + createdDate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
