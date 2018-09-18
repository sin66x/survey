package com.roozaneh.survey.service;

import com.roozaneh.survey.domain.Result;

import java.util.List;

public interface ResultService {

    public void save(Result result);
    public List<Result> findAll();
    public List<Result> findAllTextAnswers();
}
