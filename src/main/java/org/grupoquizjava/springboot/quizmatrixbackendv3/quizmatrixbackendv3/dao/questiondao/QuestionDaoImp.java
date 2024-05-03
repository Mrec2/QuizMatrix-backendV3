package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.dao.questiondao;

import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.QuestionModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDaoImp implements IQuestionDao {

    private Connection connection;

    public QuestionDaoImp(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<QuestionModel> getNQuestionsByCategory(String category, int limit) throws SQLException {

        List<QuestionModel> questions = new ArrayList<>();
        String sql = "SELECT * FROM questions where typeQuestion = ? ORDER BY RAND() LIMIT ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, category);
            preparedStatement.setInt(2, limit);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String question = resultSet.getString("bodyQuestion");
                    // Find out how can we implement this code for getting options because now they're in two tables.
//                    List<String> options = Arrays.asList(
//                            resultSet.getString("")
//                    )
                QuestionModel theQuestion = new QuestionModel(question);
                questions.add(theQuestion);
                }
            }
        }

        return questions;
    }
}
