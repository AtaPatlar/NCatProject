package com.example.demo.dto.response.manager;

import com.example.demo.entity.Consumer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FindAllTeacherResponse {
    List<Consumer> teachers;
}
