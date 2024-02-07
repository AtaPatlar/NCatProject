package com.example.demo.service;

import com.example.demo.entity.Question;
import com.example.demo.entity.SurveyQuestion;
import com.example.demo.exception.custom.QuestionNotExistsException;
import com.example.demo.repository.SurveyQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyQuestionService {

    private final SurveyQuestionRepository surveyQuestionRepository;
    public final QuestionService questionService;

    public SurveyQuestionService(SurveyQuestionRepository surveyQuestionRepository, QuestionService questionService) {
        this.surveyQuestionRepository = surveyQuestionRepository;
        this.questionService = questionService;
    }
    public void save(List<Question> questions , String surveyId){

        for (Question question:questions){
            if (!questionService.existsById(question.getId())) {
                System.out.println("HAta yazmadı");
                throw new QuestionNotExistsException();
            }
        }

        for (Question question:questions){
            SurveyQuestion surveyQuestion = new SurveyQuestion();
            surveyQuestion.setQuestionId(question.getId());
            surveyQuestion.setSurveyId(surveyId);
            surveyQuestionRepository.save(surveyQuestion);
        }
    }
    public List<SurveyQuestion> findBySurveyId(String surveyId){
        return surveyQuestionRepository.findAllBySurveyId(surveyId);
    }

    public void deleteQuestionBySurvey(String surveyId) {

        surveyQuestionRepository.deleteBySurveyId(surveyId);
    }

    public List<SurveyQuestion> findAllBySurveyId(String surveyId) {
       return surveyQuestionRepository.findAllBySurveyId(surveyId);
    }

    public void deleteByQuestionId(String id) {

        surveyQuestionRepository.deleteByQuestionId(id);
    }

    public List<SurveyQuestion> getBySurveyId(String surveyId) {
        return surveyQuestionRepository.findAllBySurveyId(surveyId);
    }
}
