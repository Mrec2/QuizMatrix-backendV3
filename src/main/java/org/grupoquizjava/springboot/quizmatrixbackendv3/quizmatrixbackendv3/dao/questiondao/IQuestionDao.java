package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.dao.questiondao;

import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.Question;
import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.QuestionModel;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;


public interface IQuestionDao {

    public List<Question> getNQuestionsByCategory(String categoria, int limit) throws SQLException;

}
