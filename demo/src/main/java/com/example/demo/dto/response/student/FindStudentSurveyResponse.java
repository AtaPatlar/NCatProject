package com.example.demo.dto.response.student;

import com.example.demo.entity.Survey;
import com.example.demo.entity.SurveyStudent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FindStudentSurveyResponse {

    List<Survey> surveys;
}
