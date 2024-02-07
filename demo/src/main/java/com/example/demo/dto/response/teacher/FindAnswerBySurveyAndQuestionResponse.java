package com.example.demo.dto.response.teacher;

import com.example.demo.entity.Answer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FindAnswerBySurveyAndQuestionResponse {

    List<Answer> answers;
}
