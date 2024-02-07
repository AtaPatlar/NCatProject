package com.example.demo.dto.response.teacher;

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
public class FindAllQuestionsResponse {
    List<Question> questions;
}
