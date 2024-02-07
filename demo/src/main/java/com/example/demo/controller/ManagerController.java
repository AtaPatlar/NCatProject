package com.example.demo.controller;


import com.example.demo.dto.request.manager.ChangeConsumerInfoRequest;
import com.example.demo.dto.request.manager.FindAnswersBySurveyAndQuestionRequest;
import com.example.demo.dto.request.manager.FindSurveyByTeacherResponse;
import com.example.demo.dto.request.manager.RegisterRequestWithToken;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.dto.response.manager.FindAllSurveyResponse;
import com.example.demo.dto.response.manager.FindAllTeacherResponse;
import com.example.demo.dto.response.manager.FindAnswersBySurveyAndQuestionResponse;
import com.example.demo.dto.response.FindAllStudentResponse;
import com.example.demo.service.ManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/findAllSurvey")
    public ResponseEntity<FindAllSurveyResponse> getAllSurvey(@RequestParam String token){
        return ResponseEntity.ok(managerService.getAllSurvey(token));
    }

    @PostMapping("/findAnswersBySurveyAndQuestion")
    public ResponseEntity<FindAnswersBySurveyAndQuestionResponse> getAnswers(@RequestBody FindAnswersBySurveyAndQuestionRequest findAnswersBySurveyAndQuestionRequest){
        return ResponseEntity.ok(managerService.findAnswersBySurveyAndQuestion(findAnswersBySurveyAndQuestionRequest));
    }

    @PostMapping("/addStudent")
    public ResponseEntity<BaseResponse> addStudent(@RequestBody RegisterRequestWithToken registerRequestWithToken){
        return ResponseEntity.ok(managerService.addConsumer(registerRequestWithToken));
    }
    @PostMapping("/addTeacher")
    public ResponseEntity<BaseResponse> addTeacher(@RequestBody RegisterRequestWithToken registerRequestWithToken){
        return ResponseEntity.ok(managerService.addConsumer(registerRequestWithToken));
    }
    @PostMapping("/addManager")
    public ResponseEntity<BaseResponse> addManager(@RequestBody RegisterRequestWithToken registerRequestWithToken){
        return ResponseEntity.ok(managerService.addConsumer(registerRequestWithToken));
}
    @PutMapping("/changeStudentInfo")
    public ResponseEntity<BaseResponse> changeStudentInfo(@RequestBody ChangeConsumerInfoRequest changeConsumerInfoRequest){
        return ResponseEntity.ok(managerService.changeConsumerInfo(changeConsumerInfoRequest));
    }
    @PutMapping("/changeTeacherInfo")
    public ResponseEntity<BaseResponse> changeTeacherInfo(@RequestBody ChangeConsumerInfoRequest changeConsumerInfoRequest){
        return ResponseEntity.ok(managerService.changeConsumerInfo(changeConsumerInfoRequest));
    }
    @GetMapping("/findAllStudent")
    public ResponseEntity<FindAllStudentResponse> findAllStudent (@RequestParam String token){
        return ResponseEntity.ok(managerService.findAllStudent(token));
    }
    @GetMapping("/findAllTeacher")
    public ResponseEntity<FindAllTeacherResponse> findAllTeacher (@RequestParam String token){
        return ResponseEntity.ok(managerService.findAllTeacher(token));
    }
    @GetMapping("/findSurveysByTeacher")
    public ResponseEntity<FindSurveyByTeacherResponse> findSurveysByTeacher(@RequestParam String token){
        return ResponseEntity.ok(managerService.getSurveyByTeacher(token));
    }


}
