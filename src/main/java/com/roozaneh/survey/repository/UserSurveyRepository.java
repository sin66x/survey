package com.roozaneh.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.roozaneh.survey.domain.UserSurvey;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 9/14/18
 * Time: 1:54 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface UserSurveyRepository extends JpaRepository<UserSurvey, Integer> {
}
