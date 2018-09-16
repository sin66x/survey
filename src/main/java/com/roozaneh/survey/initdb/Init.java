package com.roozaneh.survey.initdb;

import com.roozaneh.survey.domain.Question;
import com.roozaneh.survey.domain.Survey;
import com.roozaneh.survey.domain.SurveyPart;
import com.roozaneh.survey.repository.QuestionRepository;
import com.roozaneh.survey.repository.SurveyPartRepository;
import com.roozaneh.survey.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 9/14/18
 * Time: 2:52 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class Init {
    @Autowired
    SurveyPartRepository surveyPartRepository;

    @Autowired
    SurveyRepository surveyRepository;

    @Autowired
    QuestionRepository questionRepository;

    public static void main(String[] args) throws IOException, ParseException {
        Init init = new Init();
        init.makeSurveys();
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

    public void deleteSurveys() {
        surveyRepository.deleteAll();
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

    public void deleteSurveyParts() {
        surveyPartRepository.deleteAll();
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
    public  void deleteQuestions(){
        questionRepository.deleteAll();
    }
}


