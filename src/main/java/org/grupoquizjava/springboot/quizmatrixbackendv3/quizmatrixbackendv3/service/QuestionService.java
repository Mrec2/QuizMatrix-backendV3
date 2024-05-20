package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.service;

import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.Question;

import java.sql.SQLException;
import java.util.List;

public interface QuestionService {

    List<Question> get20Questions (String category) throws SQLException;
}
