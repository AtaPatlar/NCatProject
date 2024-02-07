package com.example.demo.repository;


import com.example.demo.entity.Answer;
import com.example.demo.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,String> {
    Optional<Answer> findOptionalByQuestionIdAndSurveyId(String questionId,String surveyId);

    void deleteBySurveyId(String surveyId);

    void deleteByQuestionId(String questionId);
    List<Answer> findAllByQuestionIdAndSurveyId(String questionId,String surveyId);
}
