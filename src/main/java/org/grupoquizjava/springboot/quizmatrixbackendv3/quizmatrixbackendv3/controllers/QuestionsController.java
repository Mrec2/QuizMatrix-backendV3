package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.controllers;

import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.Answer;
import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.Question;
import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.service.IQuestionService;
import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.*;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "*")
public class QuestionsController {

    @Autowired
    IQuestionService questionService;

    List<Question> questions;

    @PostMapping("/{language}")
    public ResponseEntity<Object> getQuestions(@PathVariable String language) {

        String messageTest = "This is Working nice";
        System.out.println("messageTest = " + messageTest);
        System.out.println("The language that you select is " + language);

        List<Map<String, Object>> myQuestions = new ArrayList<>();

        QuestionService qservice = new QuestionService();

        try {
            questions = questionService.get20Questions(language);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        List<Answer> answers = null;

        for(Question q : questions) {

            Map<String, Object> question = new HashMap<>();
            question.put("question", q.getBodyQuestion());
            List<String> bodyOptions = new ArrayList<>();
            answers = q.getAnswers().subList(0, 4);
            Collections.shuffle(answers);
            for(Answer a : answers) {
                bodyOptions.add(a.getBodyAnswer());
            }
            question.put("bodyOptions", bodyOptions);
            myQuestions.add(question);;
        }

        return ResponseEntity.ok().body(myQuestions);

    }

}
