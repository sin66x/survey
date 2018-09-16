package com.roozaneh.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import com.roozaneh.survey.initdb.Init;

import java.io.IOException;
import java.text.ParseException;

@SpringBootApplication
public class SurveyApplication {

//    @Autowired
//    Init init;
//
//    @PostConstruct
//    private void initDb(){
//        try {
//            init.deleteQuestions();
//            init.deleteSurveyParts();
//            init.deleteSurveys();
//
//            init.makeSurveys();
//            init.makeSurveyParts();
//            init.makeQuestions();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

	public static void main(String[] args) {
		SpringApplication.run(SurveyApplication.class, args);
	}
}
