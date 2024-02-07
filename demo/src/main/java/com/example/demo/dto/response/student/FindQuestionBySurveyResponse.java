package com.example.demo.dto.response.student;

import com.example.demo.entity.Question;
import com.example.demo.entity.SurveyQuestion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FindQuestionBySurveyResponse {

    List<Question> questions;

}
