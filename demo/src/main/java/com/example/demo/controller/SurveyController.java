package com.example.demo.controller;

import com.example.demo.service.SurveyService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SurveyController {

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }
}
