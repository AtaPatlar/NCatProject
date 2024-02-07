package com.example.demo.repository;

import com.example.demo.dto.response.teacher.FindMySurveyResponse;
import com.example.demo.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurveyRepository extends JpaRepository<Survey,String> {
    List<Survey> findAllByTeacherId(String id);

}
