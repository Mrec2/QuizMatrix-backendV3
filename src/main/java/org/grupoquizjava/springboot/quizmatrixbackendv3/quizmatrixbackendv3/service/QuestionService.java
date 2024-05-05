package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.service;

import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.dao.questiondao.QuestionDaoImp;
import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.QuestionModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

// This class interacts with DAO , pass the connection and return the questions.

public class QuestionService {

    private QuestionDaoImp questionDaoImp;


    public QuestionService (Connection connection) {
        System.out.println("connection in Question Service connection = " + connection);
        questionDaoImp =new QuestionDaoImp(connection) ;
    }

    public List<QuestionModel> get20Questions (String category, int limit) throws SQLException {


        return questionDaoImp.getNQuestionsByCategory(category, limit);
    }

}
