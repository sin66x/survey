package com.roozaneh.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.roozaneh.survey.domain.SurveyPart;
/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 9/14/18
 * Time: 2:08 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface SurveyPartRepository extends JpaRepository<SurveyPart, Integer>{
    public SurveyPart findByTitle(String s);
}
