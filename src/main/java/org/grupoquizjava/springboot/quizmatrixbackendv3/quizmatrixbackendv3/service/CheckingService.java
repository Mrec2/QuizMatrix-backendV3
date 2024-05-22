package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.service;

import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.AnswerUser;
import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.Question;

import java.util.List;
import java.util.Map;

public interface CheckingService {

    Integer score(List<AnswerUser> answers, List<Question> questionsStored);

}
