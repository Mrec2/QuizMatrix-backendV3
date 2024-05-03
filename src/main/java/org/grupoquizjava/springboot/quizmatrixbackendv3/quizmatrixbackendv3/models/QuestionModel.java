package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models;

import java.util.List;

public class QuestionModel {

    private String question;
//    private List <String> options;

    public QuestionModel(String question /*, List<String> options*/) {
        this.question = question;
//        this.options = options;
    }

    public String getQuestion() {
        return question;
    }

//    public List<String> getOptions() {
//        return options;
//    }
}
