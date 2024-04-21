package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.dao.questiondao;

import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.QuestionModel;

import java.sql.SQLException;
import java.util.List;

public interface IQuestionDao {


    public List<QuestionModel> getNQuestionsByCategory(String categoria, int limit) throws SQLException;
}
