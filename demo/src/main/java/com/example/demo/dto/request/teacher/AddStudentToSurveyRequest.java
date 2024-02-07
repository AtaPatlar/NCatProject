package com.example.demo.dto.request.teacher;

import com.example.demo.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AddStudentToSurveyRequest {

    private List<Student> students;
    private String surveyId;
    private String token;
}
