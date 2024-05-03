package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.controllers;

import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.dao.questiondao.QuestionDaoImp;
import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.QuestionModel;
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

            // Aquí puedes realizar operaciones con la conexión

            Map<String, Object> json = new HashMap<>();
            QuestionDaoImp questionDaoImp = new QuestionDaoImp(connection);
            List < QuestionModel> question = questionDaoImp.getNQuestionsByCategory(language, 20);


            json.put("prueba", "prueba");
            json.put("preguntadebasededatos", question);

            return ResponseEntity.ok().body(json);
        } finally {
            // Asegúrate de cerrar la conexión cuando hayas terminado con ella
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    // Manejar la excepción de alguna manera adecuada
                }
            }
        }
    }
}
