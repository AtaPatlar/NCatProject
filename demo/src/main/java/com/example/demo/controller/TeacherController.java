package com.example.demo.controller;

import com.example.demo.dto.request.teacher.*;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.dto.response.FindAllStudentResponse;
import com.example.demo.dto.response.teacher.*;
import com.example.demo.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @PostMapping("/addSurvay")
    public ResponseEntity<BaseResponse> addSurvey (@RequestBody AddSurveyRequest addSurveyRequest){
        return ResponseEntity.ok(teacherService.addSurvey(addSurveyRequest));
    }
    @GetMapping("/findMyQuestion")
    public ResponseEntity<FindMyQuestionResponse> findMyQuestion(@RequestParam  String token){
        return ResponseEntity.ok(teacherService.findMyQuestion(token));
    }
    @GetMapping("/findAllQuestion")
    public ResponseEntity<FindAllQuestionsResponse> findAllQuestion(@RequestParam String token){
        return ResponseEntity.ok(teacherService.findAllQuestion(token));
    }
    @PostMapping("/addQuestionToSurvay")
    public ResponseEntity<BaseResponse> addQuestionToSurvay(@RequestBody AddQuestionToSurveyRequest addQuestionToSurveyRequest){
        return ResponseEntity.ok(teacherService.addQuestionToSurvay(addQuestionToSurveyRequest));
    }
    @PostMapping("/addStudentToSurvey")
    public ResponseEntity<BaseResponse> addStudentToSurvey(@RequestBody AddStudentToSurveyRequest addStudentToSurveyRequest){
        return ResponseEntity.ok(teacherService.addStudentToSurvey(addStudentToSurveyRequest));
    }
    @GetMapping("/findAllStudent")
    public ResponseEntity<FindAllStudentResponse> findAllStudent(@RequestParam String token){
        return ResponseEntity.ok(teacherService.findAllStudent(token));
    }
    @PostMapping("/findAnswerBySurveyAndQuestion")
    public ResponseEntity<FindAnswerBySurveyAndQuestionResponse> findAnswerBySurveyAndQuestion(@RequestBody FindAnswerBySurveyAndQuestionRequest request){
        return ResponseEntity.ok(teacherService.findAnswerBySurveyAndQuestion(request));
    }
    @GetMapping("/findMySurvey")
    public ResponseEntity<FindMySurveyResponse> findMySurvey(@RequestParam String token){
        return ResponseEntity.ok(teacherService.findMySurvey(token));
    }
    @PostMapping("/addQuestionToPool")
    public ResponseEntity<BaseResponse> addQuestionToPool(@RequestBody AddQuestionToPoolRequest addQuestionToPoolRequest){
        return ResponseEntity.ok(teacherService.addQuestionToPool(addQuestionToPoolRequest));
    }
    @DeleteMapping("/deleteSurvey")
    public ResponseEntity<BaseResponse> deleteSurvey (@RequestBody DeleteSurveyRequest deleteSurveyRequest){
        return ResponseEntity.ok(teacherService.deleteSurvey(deleteSurveyRequest));
    }
    @DeleteMapping("/deleteQuestion")
    public ResponseEntity<BaseResponse> deleteQuestion (@RequestBody DeleteQuestionRequest deleteQuestionRequest){
        return ResponseEntity.ok(teacherService.deleteQuestion(deleteQuestionRequest));
    }
     @PostMapping("/getQuestionsBySurvey")
    public ResponseEntity<GetQuestionsBySurveyResponse> getQuestionsBySurvey(@RequestParam FindQuestionsBySurveyRequest findQuestionsBySurveyRequest){
        return ResponseEntity.ok(teacherService.findQuestionBySurvey(findQuestionsBySurveyRequest));
    }
    @DeleteMapping("/deleteStudent")
    public ResponseEntity<BaseResponse> deleteStudent (@RequestBody DeleteStudentRequest deleteStudentRequest){
        return ResponseEntity.ok(teacherService.deleteStudent(deleteStudentRequest));
    }

}
