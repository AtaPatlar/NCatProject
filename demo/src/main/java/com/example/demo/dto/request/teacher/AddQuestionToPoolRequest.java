package com.example.demo.dto.request.teacher;

import com.example.demo.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AddQuestionToPoolRequest {

    private String token;
    private String question;
}
