package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.controllers;

import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.QuestionModel;
import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "*")

public class QuestionsController {

    @Autowired
    private DataSource dataSource;

    @PostMapping("/{language}")
    public ResponseEntity<Object> getQuestions(@PathVariable String language) throws SQLException {
        String messageTest = "This is Working nice";
        System.out.println("messageTest = " + messageTest);
        System.out.println("The language that you select is " + language);

        Connection connection = null;
        try {
            connection = dataSource.getConnection();


            Map<String, Object> json = new HashMap<>();
            QuestionService questionService = new QuestionService(connection);
            List < QuestionModel> question = questionService.get20Questions(language, 20);
            System.out.println("question = " + question);
            json.put("questions", question);


//            json.put("test", "test");
//            json.put("questionfromdatabase", question);

            return ResponseEntity.ok().body(json);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
