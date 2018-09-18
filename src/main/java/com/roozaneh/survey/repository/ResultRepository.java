package com.roozaneh.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.roozaneh.survey.domain.Result;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 9/14/18
 * Time: 2:28 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {
    @Query("SELECT r from Result r where r.answer is not null and trim(r.answer) <> '' and r.question.type='DES'")
    public List<Result> findAllTextAnswers();
}
