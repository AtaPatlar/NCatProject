package com.example.demo.dto.response;

import com.example.demo.entity.Consumer;
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
public class FindAllStudentResponse {
    List<Consumer> students;
}
