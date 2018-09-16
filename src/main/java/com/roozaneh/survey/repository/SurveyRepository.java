package com.roozaneh.survey.repository;

import com.roozaneh.survey.domain.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyRepository extends JpaRepository<Survey,Integer> {

    public Survey findByTitle(String s);

    @Query(value = "SELECT s FROM Survey s WHERE CURRENT_DATE >= s.startTime AND s.endTime >= CURRENT_DATE")
    public List<Survey> findAllActive();
}
