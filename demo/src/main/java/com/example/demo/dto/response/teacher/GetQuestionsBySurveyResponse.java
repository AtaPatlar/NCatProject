package com.example.demo.dto.response.teacher;

import com.example.demo.entity.Question;
import com.example.demo.entity.SurveyQuestion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetQuestionsBySurveyResponse {

    List<SurveyQuestion>surveyQuestions;

}
