package com.example.demo.service;

import com.example.demo.dto.response.teacher.FindMySurveyResponse;
import com.example.demo.entity.Survey;
import com.example.demo.repository.SurveyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {

    private final SurveyRepository surveyRepository;

    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public void save(Survey survey) {
        surveyRepository.save(survey);
    }


    public List<Survey> findMySurvey(String id) {

        return surveyRepository.findAllByTeacherId(id);
    }

    public void deleteSurvey(String surveyId) {
        surveyRepository.deleteById(surveyId);
    }

    public Survey findSurveyById(String id) {

        return surveyRepository.findById(id).get();
    }

    public List<Survey> getAllSurvey() {
        return surveyRepository.findAll();
    }
}
