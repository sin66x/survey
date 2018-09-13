package com.roozaneh.survey.repository;

import com.roozaneh.survey.domain.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 9/14/18
 * Time: 1:44 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface SurveyRepository extends JpaRepository<Survey,Integer> {
    public Survey findByTitle(String s);
}
