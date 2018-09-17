package com.roozaneh.survey.domain.charts;

import com.roozaneh.survey.domain.SurveyPart;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Table(name = "v_rate_per_question")
@Immutable
public class PartRate {
    private int id;
    private int partId;
    private double answeredPercentage;
    private int average;
    private String partTitle;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "survey_part_id")
    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    @Column(name = "answered_percentage")
    public double getAnsweredPercentage() {
        return answeredPercentage;
    }

    public void setAnsweredPercentage(double answeredPercentage) {
        this.answeredPercentage = answeredPercentage;
    }

    @Column(name = "avg")
    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    @Column(name = "title")
    public String getPartTitle() {
        return partTitle;
    }

    public void setPartTitle(String partTitle) {
        this.partTitle = partTitle;
    }
}
