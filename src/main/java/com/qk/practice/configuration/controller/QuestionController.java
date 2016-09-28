package com.qk.practice.configuration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import util.DateTimeProcessor;
import util.UUIDGenerator;

import com.qk.practice.configuration.service.QuestionService;
import com.qk.practice.model.Question;
import com.qk.practice.model.Response;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService service;

    /*
     * This method will list all existing questions.
     */
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public Response listQuestions() {

        List<Question> questions = service.findAll();

        return new Response(HttpStatus.OK, "", questions);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Response listQuestion(@PathVariable("id") String id) {

        Question currentQuestion = service.findById(id);

        if (null == currentQuestion) {
            System.out.println("Question with id " + id + " not found");
            return new Response(HttpStatus.NO_CONTENT, "Question with id " + id + " not found", "");
        }

        return new Response(HttpStatus.OK, "", currentQuestion);
    }

    /**
     * This method will provide the medium to add a new question.
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public Response newQuestion(@RequestBody Question question) {
        String id = UUIDGenerator.getNewUUID();
        question.setId(id);
        question.setLastModifiedTimestamp(DateTimeProcessor.getCurrentTimeMillis());
        question.setCreatedTimestamp(DateTimeProcessor.getCurrentTimeMillis());
        service.createQuestion(question);
        return new Response(HttpStatus.OK, "Success to save new question.", id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Response updateQuestion(@PathVariable("id") String id, @RequestBody Question question) {
        System.out.println("Updating Question id: " + id);

        Question currentQuestion = service.findById(id);

        if (null == currentQuestion) {
            System.out.println("Question with id " + id + " not found");
            return new Response(HttpStatus.NO_CONTENT, "Question with id " + id + " not found.", "");
        }

        currentQuestion.setTitle(question.getTitle());
        currentQuestion.setContent(question.getContent());
        currentQuestion.setLastModifiedTimestamp(DateTimeProcessor.getCurrentTimeMillis());

        service.updateQuestion(currentQuestion);

        return new Response(HttpStatus.OK, "Success to update question.", "");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Response deleteQuestion(@PathVariable("id") String id) {

        Question currentQuestion = service.findById(id);

        if (null == currentQuestion) {
            System.out.println("Question with id " + id + " not found");
            return new Response(HttpStatus.NO_CONTENT, "Question with id " + id + " not found.", "");
        }

        service.deleteQuestion(currentQuestion);
        return new Response(HttpStatus.OK, "Question with id " + id + " is deleted.", id);
    }
}
