package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.repository;

import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.Question;

import java.sql.SQLException;
import java.util.List;


public interface QuestionRepository {

    public List<Question> getNQuestionsByCategory(String categoria, int limit) throws SQLException;

}
