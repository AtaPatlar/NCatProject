package com.example.demo.dto.request.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FindQuestionBySurveyRequest {

    private String token;
    private String surveyId;
}
