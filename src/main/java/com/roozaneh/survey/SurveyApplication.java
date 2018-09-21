package com.roozaneh.survey;

import com.roozaneh.survey.domain.Survey;
import com.roozaneh.survey.domain.User;
import com.roozaneh.survey.initdb.Init;
import com.roozaneh.survey.service.SurveyService;
import com.roozaneh.survey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class SurveyApplication {

    @Autowired
    Init init;

    @Autowired
    SurveyService surveyService;

    @Autowired
    UserService userService;

    @PostConstruct
    private void initDb() {
        User user =  userService.findByUsername("admin");
        if (user == null){
            userService.createUser("admin","admin","ADMIN");
        }

        init.giveAllSurveyAccessToAdmin();

        List<Survey> allSurveys = surveyService.findAll();
        if (allSurveys == null || allSurveys.size() == 0) {
            try {
                init.makeSurveys();
                init.makeSurveyParts();
                init.makeQuestions();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }

    public static void main(String[] args) {
        SpringApplication.run(SurveyApplication.class, args);
    }
}
