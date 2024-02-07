package com.example.demo.dto.request.teacher;

import com.example.demo.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DeleteQuestionRequest {

    private String surveyId;
    private String token;
    private List<Question> questions;
}
