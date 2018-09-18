package com.roozaneh.survey.repository;

import com.roozaneh.survey.domain.Survey;
import com.roozaneh.survey.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.roozaneh.survey.domain.UserSurvey;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 9/14/18
 * Time: 1:54 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface UserSurveyRepository extends JpaRepository<UserSurvey, Integer> {
    UserSurvey findByUserAndSurvey(User user, Survey survey);

    List<UserSurvey> findByUser(User user);
}
