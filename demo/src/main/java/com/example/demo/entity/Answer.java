package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Answer{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String answer;
    private String questionId;
    private String surveyId;
    private String studentId;


}
