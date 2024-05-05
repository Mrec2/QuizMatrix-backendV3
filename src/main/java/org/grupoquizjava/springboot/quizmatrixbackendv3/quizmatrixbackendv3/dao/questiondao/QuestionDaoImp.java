//package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.dao.questiondao;
//
//import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.QuestionModel;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class QuestionDaoImp implements IQuestionDao {
//
//    private Connection connection;
//
//    public QuestionDaoImp(Connection connection) {
//        this.connection = connection;
//    }
//
//    @Override
//    public List<QuestionModel> getNQuestionsByCategory(String category, int limit) throws SQLException {
//
//        List<QuestionModel> questions = new ArrayList<>();
//        String sql = "SELECT * FROM questions where typeQuestion = ? ORDER BY RAND() LIMIT ?";
//
//        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            preparedStatement.setString(1, category);
//            preparedStatement.setInt(2, limit);
//            try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                while (resultSet.next()) {
//                    String question = resultSet.getString("bodyQuestion");
//                    // Find out how can we implement this code for getting options because now they're in two tables.
////                    List<String> options = Arrays.asList(
////                            resultSet.getString("")
////                    )
//                QuestionModel theQuestion = new QuestionModel(question);
//                questions.add(theQuestion);
//                }
//            }
//        }
//
//        return questions;
//    }
//}

// JUAN HAVE TO ADAPT THE CODE USING HIBERNATE. THIS CODE IS AN EXAMPLE THAT CHECKS IF THE API REST CAN COMMUNICATE WITH MYSQL.
//  - DATABASE HAVE TO USE ENGLISH NOMENCLATURE, ALSO API REST.

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
        String sql = "SELECT q.idQuestion, q.bodyQuestion, a.bodyAnswer FROM questions q " +
                "LEFT JOIN answer a ON q.idQuestion = a.idQuestion " +
                "WHERE q.typeQuestion = ? " +
                "ORDER BY RAND() LIMIT ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, category);
            preparedStatement.setInt(2, limit);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                Integer lastQuestionId = null;
                QuestionModel currentQuestion = null;
                List<String> options = new ArrayList<>();

                while (resultSet.next()) {
                    int currentQuestionId = resultSet.getInt("idQuestion");
                    if (lastQuestionId == null || lastQuestionId != currentQuestionId) {
                        if (currentQuestion != null) {
                            questions.add(currentQuestion);
                        }
                        options = new ArrayList<>(); // Reset options list
                        lastQuestionId = currentQuestionId;
                    }

                    options.add(resultSet.getString("bodyAnswer"));

                    currentQuestion = new QuestionModel(resultSet.getString("bodyQuestion"), new ArrayList<>(options));
                }
                if (currentQuestion != null) {
                    questions.add(currentQuestion);
                }
            }
        }
        System.out.println("questions in DAO = " + questions);
        return questions;
    }
}




