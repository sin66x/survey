package com.roozaneh.survey.service.impl;

import com.roozaneh.survey.domain.Result;
import com.roozaneh.survey.repository.ResultRepository;
import com.roozaneh.survey.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    ResultRepository resultRepository;
    @Override
    public void save(Result result) {
        resultRepository.save(result);
    }

    @Override
    public List<Result> findAll() {
        return resultRepository.findAll();
    }

    @Override
    public List<Result> findAllTextAnswers() {
        return resultRepository.findAllTextAnswers();
    }
}
