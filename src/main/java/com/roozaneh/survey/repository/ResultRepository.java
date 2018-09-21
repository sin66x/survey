package com.roozaneh.survey.repository;

import com.roozaneh.survey.domain.Survey;
import com.roozaneh.survey.domain.User;
import com.roozaneh.survey.domain.UserSurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.roozaneh.survey.domain.Result;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {
    @Query(value = "SELECT r FROM Result r WHERE r.user=?1 and r.question.surveyPart.survey=?2")
    List<Result> findByUserAndSurvey(User user, Survey survey);

    @Query("SELECT r from Result r where r.answer is not null and trim(r.answer) <> '' and r.question.type='DES'")
    public List<Result> findAllTextAnswers();
}
