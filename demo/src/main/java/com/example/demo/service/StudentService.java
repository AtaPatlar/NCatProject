package com.example.demo.service;


import com.example.demo.dto.request.student.AnswerQuestionRequest;
import com.example.demo.dto.request.student.ChangeCommunicationRequest;
import com.example.demo.dto.request.student.FindQuestionBySurveyRequest;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.dto.response.student.FindQuestionBySurveyResponse;
import com.example.demo.dto.response.student.FindStudentSurveyResponse;
import com.example.demo.entity.Consumer;
import com.example.demo.entity.Question;
import com.example.demo.entity.Survey;
import com.example.demo.entity.SurveyQuestion;
import com.example.demo.entity.enums.Role;
import com.example.demo.exception.custom.EmailAlreadyException;
import com.example.demo.exception.custom.InvalidFieldException;
import com.example.demo.exception.custom.InvalidRoleException;
import com.example.demo.exception.custom.TokenNotEmptyException;
import com.example.demo.repository.StudentRepository;
import com.example.demo.utility.JwtManager;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final ConsumerService consumerService;
    private final JwtManager jwtManager;
    private final SurveyStudentService surveyStudentService;
    private final SurveyQuestionService surveyQuestionService;
    private final QuestionService questionService;
    private final AnswerService answerService;

    public StudentService(StudentRepository studentRepository, ConsumerService consumerService, JwtManager jwtManager,
                          @Lazy SurveyStudentService surveyStudentService, SurveyQuestionService surveyQuestionService, QuestionService questionService, AnswerService answerService) {
        this.studentRepository = studentRepository;
        this.consumerService = consumerService;
        this.jwtManager = jwtManager;
        this.surveyStudentService = surveyStudentService;
        this.surveyQuestionService = surveyQuestionService;
        this.questionService = questionService;
        this.answerService = answerService;
    }

    public boolean isExistsById(String id){
       return consumerService.existsById(id);
    }

    public List<Consumer> findAll() {
       return consumerService.findAll();
    }

    public FindStudentSurveyResponse findStudentSurvey(String token) {

        Optional<String> id= jwtManager.getIdByToken(token);
        Optional<Consumer> consumer=consumerService.findById(id.get());
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }

        if(consumer.get().getRole()!= Role.STUDENT){
            throw new InvalidRoleException();
        }

        List<Survey> surveyStudents = surveyStudentService.findSurveyByStudentId(id.get());
        FindStudentSurveyResponse findStudentSurveyResponse = FindStudentSurveyResponse.builder()
                .surveys(surveyStudents)
                .build();

        return findStudentSurveyResponse;
        }

    public FindQuestionBySurveyResponse findQuestionBySurvey(FindQuestionBySurveyRequest findQuestionBySurveyRequest) {
        Optional<String> id= jwtManager.getIdByToken(findQuestionBySurveyRequest.getToken());
        Optional<Consumer> consumer=consumerService.findById(id.get());
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }

        if(consumer.get().getRole()!= Role.STUDENT){
            throw new InvalidRoleException();
                                                    }
        List<SurveyQuestion> surveyQuestions = surveyQuestionService.findBySurveyId(findQuestionBySurveyRequest.getSurveyId());

        List<Question> questions = new ArrayList<>();

        for (SurveyQuestion surveyQuestion: surveyQuestions){
            Question question = questionService.findQuestionById(surveyQuestion.getQuestionId());
            questions.add(question);
        }
        FindQuestionBySurveyResponse findQuestionBySurveyResponse = FindQuestionBySurveyResponse.builder()
                .questions(questions)
                .build();
        return findQuestionBySurveyResponse;
    }


    public BaseResponse answerQuestion(AnswerQuestionRequest answerQuestionRequest) {
        Optional<String> id= jwtManager.getIdByToken(answerQuestionRequest.getToken());
        Optional<Consumer> consumer=consumerService.findById(id.get());
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }

        if(consumer.get().getRole()!= Role.STUDENT){
            throw new InvalidRoleException();
        }

        return answerService.answerQuewstion(answerQuestionRequest, id.get());
    }


    public BaseResponse changeUserInfo(ChangeCommunicationRequest changeCommunicationRequest) {
        Optional<String> id= jwtManager.getIdByToken(changeCommunicationRequest.getToken());
        Optional<Consumer> consumer=consumerService.findById(id.get());
        Consumer consumer1 = consumer.get();
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }

        if(consumer.get().getRole()!= Role.STUDENT){
            throw new InvalidRoleException();
        }
        if(consumerService.findOptionalByEmail(changeCommunicationRequest.getEmail()).isPresent()){

            throw new EmailAlreadyException();
        }
        if(changeCommunicationRequest.getEmail().equals("string") || !changeCommunicationRequest.getEmail().contains("@")){
            System.err.println("email geçersiz");
            throw new InvalidFieldException();
        }

        if(changeCommunicationRequest.getPhoneNumber().equals("string") || changeCommunicationRequest.getPhoneNumber().length()<2){
            System.err.println("phone geçersiz");
            consumer1.setPhoneNumber("");

        }
        consumer1.setEmail(changeCommunicationRequest.getEmail());
        consumer1.setPhoneNumber(changeCommunicationRequest.getPhoneNumber());
        consumerService.changeInfo(consumer1);

        BaseResponse baseResponse = BaseResponse.builder()
                .message("Kaydedildi")
                .statusCode(200)
                .build();
        return baseResponse;
    }
}
