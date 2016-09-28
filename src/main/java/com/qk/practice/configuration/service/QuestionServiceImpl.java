package com.qk.practice.configuration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qk.practice.configuration.dao.QuestionDao;
import com.qk.practice.model.Question;

@Service("questionService")
@Transactional
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionDao dao;

    public Question findById(String id) {
        return dao.findById(id);
    }

    public List<Question> findByTitle(String title) {
        return dao.findByTitle(title);
    }

    public List<Question> findAll() {
        return dao.findAll();
    }

    public void createQuestion(Question question) {
        dao.createQuestion(question);
    }

    public void deleteQuestion(Question question) {
        dao.deleteQuestion(question);
    }

    /*
     * Since the method is running with Transaction, No need to call hibernate
     * update explicitly. Just fetch the entity from db and update it with
     * proper values within transaction. It will be updated in db once
     * transaction ends.
     */
    public void updateQuestion(Question question) {
        Question entity = dao.findById(question.getId());
        if (null != entity) {
            entity.setTitle(question.getTitle());
            entity.setContent(question.getContent());
            entity.setLastModifiedTimestamp(question.getLastModifiedTimestamp());
        }
    }

}
