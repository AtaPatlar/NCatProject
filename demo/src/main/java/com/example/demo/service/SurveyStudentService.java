package com.example.demo.service;


import com.example.demo.entity.Student;
import com.example.demo.entity.Survey;
import com.example.demo.entity.SurveyStudent;
import com.example.demo.exception.custom.OwnerNotFoundException;
import com.example.demo.repository.SurveyStudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SurveyStudentService {

    private final SurveyStudentRepository surveyStudentRepository;
    private final StudentService studentService;
    private final ConsumerService consumerService;
    private final SurveyService surveyService;

    public SurveyStudentService(SurveyStudentRepository surveyStudentRepository, StudentService studentService, ConsumerService consumerService, SurveyService surveyService) {
        this.surveyStudentRepository = surveyStudentRepository;
        this.studentService = studentService;
        this.consumerService = consumerService;
        this.surveyService = surveyService;
    }


    public void saveStudent(List<Student> students, String id) {
        for (Student student : students) {
            if (!consumerService.existsById(student.getId())) {
                throw new OwnerNotFoundException();
            }
        }
        for (Student student: students){
            SurveyStudent surveyStudent = new SurveyStudent();
            surveyStudent.setStudentId(student.getId());
            surveyStudent.setSurveyId(id);
            surveyStudentRepository.save(surveyStudent);
    }
    }

    public void deleteStudentBySurveyId(String surveyId) {

        surveyStudentRepository.deleteBySurveyId(surveyId);
    }
    public void deleteStudent(Student student) {
        surveyStudentRepository.deleteByStudentId(student.getId());
    }
    public List<Survey> findSurveyByStudentId(String id) {

        List<Survey> surveys = new ArrayList<>();
        for (SurveyStudent surveyStudent: surveyStudentRepository.findAllByStudentId(id)) {

            Survey survey = new Survey();
            survey.setId(surveyStudent.getSurveyId());
            survey.setSurveyName(surveyService.findSurveyById(surveyStudent.getSurveyId()).getSurveyName());
            surveys.add(survey);
        }
        return surveys;
    }
}
