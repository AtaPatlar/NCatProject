package com.example.demo.controller;


import com.example.demo.service.SurveyQuestionService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SurveyQuestionController {

    private final SurveyQuestionService surveyQuestionService;

    public SurveyQuestionController(SurveyQuestionService surveyQuestionService) {
        this.surveyQuestionService = surveyQuestionService;
    }
}
