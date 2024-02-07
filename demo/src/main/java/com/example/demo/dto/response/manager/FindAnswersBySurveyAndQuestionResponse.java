package com.example.demo.dto.response.manager;

import com.example.demo.entity.Answer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FindAnswersBySurveyAndQuestionResponse {

    private HashMap<String, List<Answer>> questionAndAnswers;


}
