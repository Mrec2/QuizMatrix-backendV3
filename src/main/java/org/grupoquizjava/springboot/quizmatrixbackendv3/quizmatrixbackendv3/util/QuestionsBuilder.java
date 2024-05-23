package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.util;

import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.Answer;
import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.Question;
import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.service.QuestionService;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.*;

@Component
public class QuestionsBuilder {


    List<Question> questions;

    public QuestionsBuilder() {
    }

    public List<Map<String, Object>> getqBuilder (QuestionService questionService, String language) {
        List<Map<String, Object>> qBuilder = new ArrayList<>();

        try {
            questions = questionService.get20Questions(language);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        List<Answer> answers = null;
        for(Question q : questions) {

            Map<String, Object> question = new HashMap<>();
            question.put("question", q.getBodyQuestion());
            List<String> bodyOptions = new ArrayList<>();
            answers = q.getAnswers().subList(0, 4);
            Collections.shuffle(answers);
            for(Answer a : answers) {
                bodyOptions.add(a.getBodyAnswer());
            }
            question.put("bodyOptions", bodyOptions);
            qBuilder.add(question);
        }
    return qBuilder;
    }

    public List<Question> getQuestions() {
        return questions;
    }

}
