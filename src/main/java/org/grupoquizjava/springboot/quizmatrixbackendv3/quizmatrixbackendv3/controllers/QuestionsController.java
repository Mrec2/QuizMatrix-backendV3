package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.controllers;

import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.service.QuestionService;
import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.util.QuestionsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "*")
public class QuestionsController {

    @Autowired
    QuestionService questionService;

    @Autowired
    QuestionsBuilder questionsBuilder;

    @PostMapping("/{language}")
    public ResponseEntity<Object> getQuestions(@PathVariable String language) {
        List<Map<String, Object>> myQuestions = questionsBuilder.getqBuilder(questionService, language);
        return ResponseEntity.ok().body(myQuestions);

    }

}
