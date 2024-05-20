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

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.Question;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class QuestionRepositoryImpl implements QuestionRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Question> getNQuestionsByCategory(String questionClass, int limit) {

        String hql = "SELECT DISTINCT q FROM Question q JOIN FETCH q.answers WHERE q.questionClass = :category";
        TypedQuery<Question> query = em.createQuery(hql, Question.class);
        query.setParameter("category", questionClass);
        List<Question> results = query.getResultList();

        // Ordenar aleatoriamente los resultados en memoria
        Collections.shuffle(results);

        // Limitar el número de resultados
        if (results.size() > limit) {
            return results.subList(0, limit);
        } else {
            return results;
        }

    }

}




