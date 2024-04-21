package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.service;

import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.dao.questiondao.QuestionDaoImp;
import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.QuestionModel;

import java.sql.SQLException;
import java.util.List;

public class QuestionService {

    private QuestionDaoImp questionDaoImp;

    public List<QuestionModel> Get20Questions (String category, int limit) throws SQLException {


        return questionDaoImp.getNQuestionsByCategory(category, limit);
    }

}
