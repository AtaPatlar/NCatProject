package com.example.demo.controller;


import com.example.demo.dto.request.student.AnswerQuestionRequest;
import com.example.demo.dto.request.student.ChangeCommunicationRequest;
import com.example.demo.dto.request.student.FindQuestionBySurveyRequest;
import com.example.demo.dto.request.student.FindSurveyByStudentRequest;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.dto.response.student.FindQuestionBySurveyResponse;
import com.example.demo.dto.response.student.FindStudentSurveyResponse;
import com.example.demo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("findStudentSurvey")
    public ResponseEntity<FindStudentSurveyResponse> findStudentSurvey(@RequestParam String token){
        return ResponseEntity.ok(studentService.findStudentSurvey(token));
    }
    @PostMapping("findQuestionBySurvey")
    public ResponseEntity<FindQuestionBySurveyResponse> findQuestionBySurvey (@RequestBody FindQuestionBySurveyRequest findQuestionBySurveyRequest){
        return  ResponseEntity.ok(studentService.findQuestionBySurvey(findQuestionBySurveyRequest));
    }
    @PostMapping("/answerQuestion")
    public ResponseEntity<BaseResponse> answerQuestion(@RequestBody AnswerQuestionRequest answerQuestionRequest){
        return ResponseEntity.ok(studentService.answerQuestion(answerQuestionRequest));
    }
    @PutMapping("/changeStudentInf")
    public ResponseEntity<BaseResponse> changeStudentInfo (@RequestBody ChangeCommunicationRequest changeCommunicationRequest){
        return ResponseEntity.ok(studentService.changeUserInfo(changeCommunicationRequest));
    }

}
