package com.example.demo.service;

import com.example.demo.dto.request.student.AnswerQuestionRequest;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.entity.Answer;
import com.example.demo.entity.Question;
import com.example.demo.repository.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer getById(String questionId,String surveyId) {
        Optional<Answer> answer = answerRepository.findOptionalByQuestionIdAndSurveyId(questionId,surveyId);
       if (answer.isPresent()){
           return answer.get();
       }
       return null;
    }

    public void deleteAnswerBySurveyId(String surveyId) {
        answerRepository.deleteBySurveyId(surveyId);
    }

    public void deleteByQuestionId(String questionId) {
        answerRepository.deleteByQuestionId(questionId);
    }

    public BaseResponse answerQuewstion(AnswerQuestionRequest answerQuestionRequest, String studentId) {

        Answer answer = Answer.builder()
                .answer(answerQuestionRequest.getAnswer())
                .studentId(studentId)
                .questionId(answerQuestionRequest.getQuestionId())
                .surveyId(answerQuestionRequest.getSurveyId())
                .build();

        answerRepository.save(answer);

        BaseResponse baseResponse = BaseResponse.builder()
                .statusCode(200)
                .message("Soru Kaydedildi")
                .build();
        return baseResponse;
    }

    public List<Answer> findAllAnswersByQuestionIdAndSurveyId(String id, String surveyId) {
        return answerRepository.findAllByQuestionIdAndSurveyId(id,surveyId);
    }
}
