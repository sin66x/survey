package com.roozaneh.survey.initdb;

import com.roozaneh.survey.domain.*;
import com.roozaneh.survey.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class Init {
    @Autowired
    SurveyPartRepository surveyPartRepository;

    @Autowired
    SurveyRepository surveyRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    UserSurveyRepository userSurveyRepository;

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) throws IOException, ParseException {
        Init init = new Init();
        init.giveAllSurveyAccessToAdmin();
    }

    public void makeSurveys() throws IOException, ParseException {
        File file = new File(getClass().getClassLoader().getResource("initdata/survey.csv").getFile());
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        br.readLine();
        while ((st = br.readLine()) != null) {
            Survey survey = new Survey();
            survey.setCreatedDate(new Date());
            survey.setTitle(st.split(",")[0]);
            DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:SS");
            survey.setStartTime(format.parse(st.split(",")[1]));
            survey.setEndTime(format.parse(st.split(",")[2]));
            surveyRepository.save(survey);
        }

    }

    public void makeSurveyParts() throws IOException, ParseException {
        File file = new File(getClass().getClassLoader().getResource("initdata/survey-parts.csv").getFile());
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        br.readLine();
        while ((st = br.readLine()) != null) {
            SurveyPart surveyPart = new SurveyPart();
            surveyPart.setTitle(st.split(",")[0]);
            surveyPart.setSurvey(surveyRepository.findByTitle(st.split(",")[1]));

            surveyPartRepository.save(surveyPart);

        }
    }

    public void makeQuestions() throws IOException, ParseException {
        File file = new File(getClass().getClassLoader().getResource("initdata/questions.csv").getFile());
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        br.readLine();
        while ((st = br.readLine()) != null) {
            Question question = new Question();
            question.setText(st.split(",")[0]);
            question.setType(st.split(",")[1]);
            question.setSurveyPart(surveyPartRepository.findByTitle(st.split(",")[2]));
            question.setInSurveyIndex(st.split(",")[3]);
            questionRepository.save(question);
        }
    }

    public void giveAllSurveyAccessToAdmin(){
        User user = userRepository.findByUsername("admin");
        List<Survey> surveys = surveyRepository.findAll();
        for (Survey survey : surveys) {
            UserSurvey userSurvey = new UserSurvey();
            userSurvey.setSurvey(survey);
            userSurvey.setUser(user);
            if (userSurveyRepository.findByUserAndSurvey(user,survey)==null)
                userSurveyRepository.saveAndFlush(userSurvey);
        }
    }
}


