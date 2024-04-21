package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.dao.questiondao;

import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.QuestionModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDaoImp implements IQuestionDao{

    private Connection connection;

    public QuestionDaoImp (Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<QuestionModel> getNQuestionsByCategory(String category, int limit) throws SQLException {

        List <QuestionModel> questions = new ArrayList<>();


        return null;
    }
}
