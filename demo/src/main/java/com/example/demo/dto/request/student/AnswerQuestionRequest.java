package com.example.demo.dto.request.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AnswerQuestionRequest {

    private String questionId;
    private String surveyId;
    private String token;
    private String answer;
}
