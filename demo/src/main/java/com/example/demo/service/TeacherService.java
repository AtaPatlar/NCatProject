package com.example.demo.service;


import com.example.demo.dto.request.teacher.*;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.dto.response.FindAllStudentResponse;
import com.example.demo.dto.response.teacher.*;
import com.example.demo.entity.*;
import com.example.demo.entity.enums.Role;
import com.example.demo.exception.custom.InvalidRoleException;
import com.example.demo.exception.custom.TokenNotEmptyException;
import com.example.demo.utility.JwtManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {


    private final JwtManager jwtManager;
    private final ConsumerService consumerService;
    private final SurveyService surveyService;
    private final QuestionService questionService;
    private final SurveyQuestionService surveyQuestionService;
    private final SurveyStudentService surveyStudentService;
    private final StudentService studentService;
    private final AnswerService answerService;

    public TeacherService(JwtManager jwtManager, ConsumerService consumerService, SurveyService surveyService,
                          QuestionService questionService, SurveyQuestionService surveyQuestionService, SurveyStudentService surveyStudentService, StudentService studentService, AnswerService answerService) {
        this.jwtManager = jwtManager;
        this.consumerService = consumerService;
        this.surveyService = surveyService;
        this.questionService = questionService;
        this.surveyQuestionService = surveyQuestionService;
        this.surveyStudentService = surveyStudentService;
        this.studentService = studentService;
        this.answerService = answerService;
    }




    public BaseResponse addSurvey(AddSurveyRequest addSurveyRequest) {

        Optional<String> id =  jwtManager.getIdByToken(addSurveyRequest.getToken());
        Optional<Consumer> consumer = consumerService.findById(id.get());

        if(consumer.isEmpty()){
            throw new TokenNotEmptyException();
        }

        if (consumer.get().getRole()!=Role.TEACHER) {
            throw new InvalidRoleException();
        }
        Survey survey = Survey.builder()
                .surveyName(addSurveyRequest.getSurveyName())
                .teacherId(id.get())
                .build();
        surveyService.save(survey);

        BaseResponse baseResponse = BaseResponse.builder()
                .message("Ankey Kaydedili")
                .statusCode(200)
                .build();
    return baseResponse;
    }

    public FindMyQuestionResponse findMyQuestion(String token){
        Optional<String> id =  jwtManager.getIdByToken(token);
        Optional<Consumer> consumer = consumerService.findById(id.get());

        if(consumer.isEmpty()){
            throw new TokenNotEmptyException();
        }

        if (consumer.get().getRole()!=Role.TEACHER) {
            throw new InvalidRoleException();
        }

        FindMyQuestionResponse findMyQuestionResponse = FindMyQuestionResponse.builder()
                .questions(questionService.findMyQuestion(id.get()))
                .build();
        return findMyQuestionResponse;
    }

    public FindAllQuestionsResponse findAllQuestion(String token) {
        Optional<String> id =  jwtManager.getIdByToken(token);
        Optional<Consumer> consumer = consumerService.findById(id.get());

        if(consumer.isEmpty()){
             throw new TokenNotEmptyException();
        }

        if (consumer.get().getRole()!=Role.TEACHER) {
            throw new InvalidRoleException();
        }

        FindAllQuestionsResponse findAllQuestionsResponse = FindAllQuestionsResponse.builder()
                .questions(questionService.findAllQuestion())
                .build();
        return findAllQuestionsResponse;
    }

    public BaseResponse addQuestionToSurvay(AddQuestionToSurveyRequest addQuestionToSurveyRequest) {
        Optional<String> id =  jwtManager.getIdByToken(addQuestionToSurveyRequest.getToken());
        Optional<Consumer> consumer = consumerService.findById(id.get());

        if(consumer.isEmpty()){
            throw new TokenNotEmptyException();
        }
        if (consumer.get().getRole()!=Role.TEACHER) {
            throw new InvalidRoleException();
        }
        surveyQuestionService.save(addQuestionToSurveyRequest.getQuestions(),addQuestionToSurveyRequest.getSurveyId());

        return BaseResponse.builder()
                .statusCode(200)
                .message("Sorularınız eklendi")
                .build();
    }


    public BaseResponse addStudentToSurvey(AddStudentToSurveyRequest addStudentToSurveyRequest) {
        Optional<String> id =  jwtManager.getIdByToken(addStudentToSurveyRequest.getToken());
        Optional<Consumer> consumer = consumerService.findById(id.get());

        if(consumer.isEmpty()){
            throw new TokenNotEmptyException();
        }
        if (consumer.get().getRole()!=Role.TEACHER) {
            throw new InvalidRoleException();
        }

        surveyStudentService.saveStudent(addStudentToSurveyRequest.getStudents(),addStudentToSurveyRequest.getSurveyId());

        return BaseResponse.builder()
                .message("Öğrenci kaydedildi")
                .statusCode(200)
                .build();
    }
    public FindAnswerBySurveyAndQuestionResponse findAnswerBySurveyAndQuestion
            (FindAnswerBySurveyAndQuestionRequest findAnswerBySurveyAndQuestionRequest){

        Optional<String> id = jwtManager.getIdByToken(findAnswerBySurveyAndQuestionRequest.getToken());
        Optional<Consumer> consumer = consumerService.findById(id.get());

        if (consumer.isEmpty()) {
            throw new TokenNotEmptyException();
        }
        if (consumer.get().getRole() != Role.TEACHER) {
            throw new InvalidRoleException();
        }

        List<SurveyQuestion> surveyQuestions =surveyQuestionService.findBySurveyId(findAnswerBySurveyAndQuestionRequest.getSurveyId());
        List<Answer> answers = new ArrayList<>();

        for (SurveyQuestion surveyQuestion: surveyQuestions){
            Answer answer = answerService.getById(surveyQuestion.getQuestionId(),surveyQuestion.getSurveyId());
            if (answer!=null) {
                answers.add(answer);
            }

        }
        FindAnswerBySurveyAndQuestionResponse findAnswerBySurveyAndQuestionResponse = FindAnswerBySurveyAndQuestionResponse.builder()
                .answers(answers)
                .build();

 return findAnswerBySurveyAndQuestionResponse;
    }
    public FindAllStudentResponse findAllStudent(String token) {
        Optional<String> id = jwtManager.getIdByToken(token);
        Optional<Consumer> consumer = consumerService.findById(id.get());

        if (consumer.isEmpty()) {
            throw new TokenNotEmptyException();
        }
        if (consumer.get().getRole() != Role.TEACHER) {
            throw new InvalidRoleException();
        }

        FindAllStudentResponse findAllStudentResponse = FindAllStudentResponse.builder()
                .students(studentService.findAll())
                .build();

        return findAllStudentResponse;
    }


    public FindMySurveyResponse findMySurvey(String token) {
        Optional<String> id = jwtManager.getIdByToken(token);
        Optional<Consumer> consumer = consumerService.findById(id.get());

        if (consumer.isEmpty()) {
            throw new TokenNotEmptyException();
        }
        if (consumer.get().getRole() != Role.TEACHER) {
            throw new InvalidRoleException();
        }
        FindMySurveyResponse findMySurveyResponse = FindMySurveyResponse.builder()
                .surveys(surveyService.findMySurvey(id.get()))
                .build();
        return findMySurveyResponse;
    }

    public BaseResponse addQuestionToPool(AddQuestionToPoolRequest addQuestionToPoolRequest) {
        Optional<String> id = jwtManager.getIdByToken(addQuestionToPoolRequest.getToken());
        Optional<Consumer> consumer = consumerService.findById(id.get());

        if (consumer.isEmpty()) {
            throw new TokenNotEmptyException();
        }
        if (consumer.get().getRole() != Role.TEACHER) {
            throw new InvalidRoleException();
        }
        Question question = Question.builder()
                .question(addQuestionToPoolRequest.getQuestion())
                .teacherId(id.get())
                .build();

        questionService.addQuestionToPool(question);

        BaseResponse baseResponse = BaseResponse.builder()
                .message("Soru eklendi")
                .statusCode(200)
                .build();

        return baseResponse;
    }

    public BaseResponse deleteSurvey(DeleteSurveyRequest deleteSurveyRequest) {
        Optional<String> id = jwtManager.getIdByToken(deleteSurveyRequest.getToken());
        Optional<Consumer> consumer = consumerService.findById(id.get());

        if (consumer.isEmpty()) {
            throw new TokenNotEmptyException();
        }
        if (consumer.get().getRole() != Role.TEACHER) {
            throw new InvalidRoleException();
        }
        surveyService.deleteSurvey(deleteSurveyRequest.getSurveyId());
        surveyQuestionService.deleteQuestionBySurvey(deleteSurveyRequest.getSurveyId());
        surveyStudentService.deleteStudentBySurveyId(deleteSurveyRequest.getSurveyId());
        answerService.deleteAnswerBySurveyId(deleteSurveyRequest.getSurveyId());

        BaseResponse baseResponse = BaseResponse.builder()
                .message("Silindi")
                .statusCode(200)
                .build();
        return baseResponse;
    }

    public BaseResponse deleteQuestion(DeleteQuestionRequest deleteQuestionRequest) {
        Optional<String> id = jwtManager.getIdByToken(deleteQuestionRequest.getToken());
        Optional<Consumer> consumer = consumerService.findById(id.get());

        if (consumer.isEmpty()) {
            throw new TokenNotEmptyException();
        }
        if (consumer.get().getRole() != Role.TEACHER) {
            throw new InvalidRoleException();
        }
       //List<SurveyQuestion> surveyQuestions = surveyQuestionService.findBySurveyId(deleteQuestionRequest.getSurveyId());

        for (Question question : deleteQuestionRequest.getQuestions()){
         surveyQuestionService.deleteByQuestionId(question.getId());
         answerService.deleteByQuestionId(question.getId());
        }
        BaseResponse baseResponse = BaseResponse.builder()
                .message("Soru ve cevapları silindi")
                .statusCode(200)
                .build();
        return baseResponse;
    }


    public GetQuestionsBySurveyResponse findQuestionBySurvey(FindQuestionsBySurveyRequest findQuestionsBySurveyRequest) {
        Optional<String> id = jwtManager.getIdByToken(findQuestionsBySurveyRequest.getToken());
        Optional<Consumer> consumer = consumerService.findById(id.get());

        if (consumer.isEmpty()) {
            throw new TokenNotEmptyException();
        }
        if (consumer.get().getRole() != Role.TEACHER) {
            throw new InvalidRoleException();
        }

        return GetQuestionsBySurveyResponse.builder()
                .surveyQuestions(surveyQuestionService.findAllBySurveyId(findQuestionsBySurveyRequest.getSurveyId()))
                .build();
    }

    public BaseResponse deleteStudent(DeleteStudentRequest deleteStudentRequest) {
        Optional<String> id = jwtManager.getIdByToken(deleteStudentRequest.getToken());
        Optional<Consumer> consumer = consumerService.findById(id.get());

        if (consumer.isEmpty()) {
            throw new TokenNotEmptyException();
        }
        if (consumer.get().getRole() != Role.TEACHER) {
            throw new InvalidRoleException();
        }

        for (Student student : deleteStudentRequest.getStudents()){
            surveyStudentService.deleteStudent(student);
        }

        BaseResponse baseResponse = BaseResponse.builder()
                .message("Öğrenci silindi")
                .statusCode(200)
                .build();
        return baseResponse;
    }
}
