package com.example.demo.service;


import com.example.demo.entity.Question;
import com.example.demo.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> findMyQuestion(String id){
       return questionRepository.findAllByTeacherId(id);
    }

    public List<Question> findAllQuestion() {
        return questionRepository.findAll();
    }
    public boolean existsById(String id){
        return questionRepository.existsById(id);
    }

    public void addQuestionToPool(Question question) {

        questionRepository.save(question);
    }

    public Question findQuestionById(String id){
        return questionRepository.findById(id).get();
    }

    public Question getQuestionById(String questionId) {
        return questionRepository.findById(questionId).get();
    }
}
