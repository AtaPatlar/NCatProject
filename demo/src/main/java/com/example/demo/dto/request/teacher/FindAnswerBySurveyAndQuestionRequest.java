package com.example.demo.dto.request.teacher;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FindAnswerBySurveyAndQuestionRequest {

    String surveyId;
    String token;
}
