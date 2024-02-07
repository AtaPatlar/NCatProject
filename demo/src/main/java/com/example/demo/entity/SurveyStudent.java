package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SurveyStudent {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String surveyId;
    private String studentId;

    public SurveyStudent(String surveyId, String studentId) {
        this.surveyId = surveyId;
        this.studentId = studentId;
    }

    public SurveyStudent() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
