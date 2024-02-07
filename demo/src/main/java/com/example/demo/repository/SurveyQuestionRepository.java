package com.example.demo.repository;

import com.example.demo.entity.SurveyQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface SurveyQuestionRepository extends JpaRepository<SurveyQuestion,String> {

List<SurveyQuestion> findAllBySurveyId(String surveyId);

    void deleteBySurveyId(String surveyId);

    void deleteByQuestionId(String id);
}
