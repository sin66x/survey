package com.roozaneh.survey.service.impl;

import com.roozaneh.survey.domain.charts.PartRate;
import com.roozaneh.survey.domain.charts.QuestionRate;
import com.roozaneh.survey.service.ChartService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class ChartServiceImpl implements ChartService {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<QuestionRate> questionRate() {
        return entityManager.createNativeQuery("select * from roozaneh.v_rate_per_question",QuestionRate.class).getResultList();
    }

    @Override
    public List<PartRate> partRate() {
        return entityManager.createNativeQuery("select * from roozaneh.v_rate_per_part",PartRate.class).getResultList();
    }
}
