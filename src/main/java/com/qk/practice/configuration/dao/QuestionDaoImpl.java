package com.qk.practice.configuration.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.qk.practice.model.Question;

@Repository("questionDao")
public class QuestionDaoImpl extends AbstractDao<String, Question> implements QuestionDao {

    public Question findById(String id) {
        return getByKey(id);
    }

    @SuppressWarnings("unchecked")
    public List<Question> findByTitle(String title) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.like("title", title));
        criteria.addOrder(Order.asc("last_modified_timestamp"));
        return (List<Question>) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Question> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("lastModifiedTimestamp"));
        return (List<Question>) criteria.list();
    }

    public void createQuestion(Question question) {
        persist(question);
    }

    public void deleteQuestion(Question question) {
        delete(question);
    }

    public void updateQuestion(Question question) {
        update(question);

    }

}
