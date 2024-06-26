package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.service;

import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.repository.QuestionRepository;
import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

// This class interacts with DAO , pass the connection and return the questions.

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    Environment environment;

/*
    public QuestionService (Connection connection) {
        System.out.println("connection in Question Service connection = " + connection);
        questionDaoImp =new QuestionDaoImp(connection) ;
    }

 */

    public List<Question> get20Questions (String category) throws SQLException {
        return questionRepository.getNQuestionsByCategory(category, Integer.parseInt(environment.getProperty("config.int.limit")));
    }

}
