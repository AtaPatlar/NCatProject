package com.example.demo.controller;


import com.example.demo.service.SurveyStudentService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SurveyStudentController {

    private final SurveyStudentService surveyStudentService;

    public SurveyStudentController(SurveyStudentService surveyStudentService) {
        this.surveyStudentService = surveyStudentService;
    }
}
