package com.qk.practice.configuration.dao;

import java.util.List;

import com.qk.practice.model.Question;

public interface QuestionDao {
    Question findById(String id);

    List<Question> findByTitle(String title);

    List<Question> findAll();

    void createQuestion(Question question);

    void deleteQuestion(Question question);

    void updateQuestion(Question question);

}
