package com.example.demo.dto.request.manager;

import com.example.demo.entity.Consumer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FindSurveyByTeacherResponse {

    HashMap<String, Consumer> teachers;
}
