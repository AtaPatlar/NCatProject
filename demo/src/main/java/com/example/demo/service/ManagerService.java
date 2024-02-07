package com.example.demo.service;

import com.example.demo.dto.request.manager.ChangeConsumerInfoRequest;
import com.example.demo.dto.request.manager.FindAnswersBySurveyAndQuestionRequest;
import com.example.demo.dto.request.manager.FindSurveyByTeacherResponse;
import com.example.demo.dto.request.manager.RegisterRequestWithToken;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.dto.response.FindAllStudentResponse;
import com.example.demo.dto.response.manager.FindAllSurveyResponse;
import com.example.demo.dto.response.manager.FindAllTeacherResponse;
import com.example.demo.dto.response.manager.FindAnswersBySurveyAndQuestionResponse;
import com.example.demo.entity.*;
import com.example.demo.entity.enums.Role;
import com.example.demo.exception.custom.*;
import com.example.demo.repository.ManagerRepository;
import com.example.demo.utility.HashPassword;
import com.example.demo.utility.JwtManager;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    private final ManagerRepository managerRepository;
    private final JwtManager jwtManager;
    private final ConsumerService consumerService;
    private final SurveyQuestionService surveyQuestionService;
    private final QuestionService questionService;
    private final SurveyService surveyService;
    private final AnswerService answerService;

    public ManagerService(ManagerRepository managerRepository, JwtManager jwtManager, ConsumerService consumerService, SurveyQuestionService surveyQuestionService, QuestionService questionService, SurveyService surveyService, AnswerService answerService) {
        this.managerRepository = managerRepository;
        this.jwtManager = jwtManager;
        this.consumerService = consumerService;
        this.surveyQuestionService = surveyQuestionService;
        this.questionService = questionService;
        this.surveyService = surveyService;
        this.answerService = answerService;
    }

    public FindAnswersBySurveyAndQuestionResponse findAnswersBySurveyAndQuestion(FindAnswersBySurveyAndQuestionRequest
                                                                                         findAnswersBySurveyAndQuestionRequest) {
        Optional<String> id= jwtManager.getIdByToken(findAnswersBySurveyAndQuestionRequest.getToken());
        Optional<Consumer> consumer=consumerService.findById(id.get());
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }

        if(consumer.get().getRole()!= Role.MANAGER){
            throw new InvalidRoleException();
        }
        List<SurveyQuestion> surveyQuestions=surveyQuestionService.getBySurveyId(findAnswersBySurveyAndQuestionRequest.getSurveyId());
        HashMap<String,List<Answer>> questionAndAnswers=new HashMap<>();
        for (SurveyQuestion surveyQuestion:surveyQuestions){
            Question question=questionService.getQuestionById(surveyQuestion.getQuestionId());

            List<Answer> answers=answerService.findAllAnswersByQuestionIdAndSurveyId(question.getId(),findAnswersBySurveyAndQuestionRequest.getSurveyId());
            questionAndAnswers.put(question.getQuestion(),answers);
        }

        FindAnswersBySurveyAndQuestionResponse response=new FindAnswersBySurveyAndQuestionResponse();
        response.setQuestionAndAnswers(questionAndAnswers);

        return response;
    }

    public BaseResponse addConsumer(RegisterRequestWithToken registerRequestWithToken) {
        Optional<String> id= jwtManager.getIdByToken(registerRequestWithToken.getToken());

        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }
        if(consumerService.findById(id.get()).get().getRole()!=Role.MANAGER){
            System.err.println("rol yetersiz");
            throw new InvalidRoleException();
        }
        Optional<Consumer> consumer=consumerService.findOptionalByEmail(registerRequestWithToken.getEmail());
        if(consumer.isPresent()){
            System.err.println("kullanıcı yok");
            throw new EmailAlreadyException();
        }
        if (!registerRequestWithToken.getEmail().contains("@")) {
            System.err.println("geçersiz email");
            throw new EmailNotValidException();
        }

        Consumer consumer1=new Consumer();
        consumer1.setEmail(registerRequestWithToken.getEmail());
        consumer1.setName(registerRequestWithToken.getName());
        consumer1.setLastName(registerRequestWithToken.getLastName());
        consumer1.setPassword(HashPassword.encrypt(registerRequestWithToken.getPassword()));
        consumer1.setPhoneNumber(registerRequestWithToken.getPhoneNumber());
        consumer1.setPhoneNumber(registerRequestWithToken.getPhoneNumber());
        consumer1.setRole(registerRequestWithToken.getRole());

        consumerService.saveConsumer(consumer1);

        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setMessage("Kayıt Yapıldı");
        baseResponse.setStatusCode(200);

        return baseResponse;
    }

    public FindAllSurveyResponse getAllSurvey(String token) {
        Optional<String> id= jwtManager.getIdByToken(token);
        Optional<Consumer> consumer=consumerService.findById(id.get());
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }

        if(consumer.get().getRole()!= Role.MANAGER){
            throw new InvalidRoleException();
        }
        FindAllSurveyResponse findAllSurveyResponse=new FindAllSurveyResponse();
        findAllSurveyResponse.setSurveys(surveyService.getAllSurvey());
        return findAllSurveyResponse;
    }

    public BaseResponse changeConsumerInfo(ChangeConsumerInfoRequest changeConsumerInfoRequest) {
        Optional<String> id= jwtManager.getIdByToken(changeConsumerInfoRequest.getToken());
        Optional<Consumer> consumer=consumerService.findById(id.get());
        Consumer consumer1 =consumerService.findById(changeConsumerInfoRequest.getUserId()).get();
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }
        if(consumer.get().getRole()!= Role.MANAGER){
            throw new InvalidRoleException();
        }
        if(consumerService.findOptionalByEmail(changeConsumerInfoRequest.getEmail()).isPresent()){

            throw new EmailAlreadyException();
        }
        if(changeConsumerInfoRequest.getEmail().equals("string") || !changeConsumerInfoRequest.getEmail().contains("@")){
            System.err.println("email geçersiz");
            throw new InvalidFieldException();
        }
        if(changeConsumerInfoRequest.getPhoneNumber().equals("string") || changeConsumerInfoRequest.getPhoneNumber().length()<2){
            System.err.println("phone geçersiz");
            throw new InvalidFieldException();
        }
        if(changeConsumerInfoRequest.getTc().equals("string") || changeConsumerInfoRequest.getTc().length()<2){
            System.err.println("tc geçersiz");
            throw new InvalidFieldException();
        }
        if(changeConsumerInfoRequest.getName().equals("string") ){
            System.err.println("isim geçersiz");
            throw new InvalidFieldException();
        }
        if(changeConsumerInfoRequest.getLastName().equals("string") ){
            System.err.println("soyisim geçersiz");
            throw new InvalidFieldException();
        }
        if(changeConsumerInfoRequest.getPassword().equals("string")) {
            System.err.println("şifre geçersiz");
            throw new InvalidFieldException();
        }

        if (changeConsumerInfoRequest.getRole()!= Role.MANAGER && changeConsumerInfoRequest.getRole()!= Role.STUDENT
                && changeConsumerInfoRequest.getRole()!= Role.TEACHER ) {
            System.err.println("role geçersiz");
            throw new InvalidFieldException();
        }

        consumer1.setRole(changeConsumerInfoRequest.getRole());
        consumer1.setEmail(changeConsumerInfoRequest.getEmail());
        consumer1.setPhoneNumber(changeConsumerInfoRequest.getPhoneNumber());
        consumer1.setName(changeConsumerInfoRequest.getName());
        consumer1.setLastName(changeConsumerInfoRequest.getLastName());
        consumer1.setPassword(HashPassword.encrypt(changeConsumerInfoRequest.getPassword()));
        consumer1.setTcNo(changeConsumerInfoRequest.getTc());

        consumerService.changeInfo(consumer1);

        BaseResponse baseResponse = BaseResponse.builder()
                .statusCode(200)
                .message("Alanlar Güncellendi")
                .build();
        return baseResponse;
    }

    public FindAllStudentResponse findAllStudent(String token) {
        Optional<String> id= jwtManager.getIdByToken(token);
        Optional<Consumer> consumer=consumerService.findById(id.get());
        Consumer consumer1 = consumer.get();
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }
        if(consumer.get().getRole()!= Role.MANAGER){
            throw new InvalidRoleException();
        }

        FindAllStudentResponse findAllStudentResponse = FindAllStudentResponse.builder()
                .students(consumerService.findAllStudent())
                .build();
        return findAllStudentResponse;
    }
    public FindAllTeacherResponse findAllTeacher(String token) {
        Optional<String> id= jwtManager.getIdByToken(token);
        Optional<Consumer> consumer=consumerService.findById(id.get());
        Consumer consumer1 = consumer.get();
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }
        if(consumer.get().getRole()!= Role.MANAGER){
            throw new InvalidRoleException();
        }

        FindAllTeacherResponse findAllTeacherResponse = FindAllTeacherResponse.builder()
                .teachers(consumerService.findAllStudent())
                .build();
        return findAllTeacherResponse;
    }

    public FindSurveyByTeacherResponse getSurveyByTeacher(String token) {

        Optional<String> id= jwtManager.getIdByToken(token);
        if (id.isEmpty()){
            throw new TokenNotEmptyException();
        }
        if(consumerService.findById(id.get()).get().getRole()!=Role.MANAGER){
            System.err.println("rol yetersiz kanka");
            throw new InvalidRoleException();
        }


        List<Survey> surveys=surveyService.getAllSurvey();
        HashMap<String ,Consumer> teacherHashMap=new HashMap<>();
        for (Survey survey:surveys){

            Consumer consumer=consumerService.findById(survey.getTeacherId()).get();
            teacherHashMap.put(survey.getSurveyName(),consumer);

        }
        FindSurveyByTeacherResponse getSurveyByTeacherResponse=new FindSurveyByTeacherResponse();
        getSurveyByTeacherResponse.setTeachers(teacherHashMap);
        return getSurveyByTeacherResponse;

    }
}
