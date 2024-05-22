package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.service;


import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.Answer;
import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.AnswerUser;
import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.Question;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckingServiceImpl implements CheckingService{


    @Override
    public Integer score(List<AnswerUser> answers, List<Question> questionsStored) {

        int count = 0;

        System.out.println("answers in checkingservice = " + answers);
        System.out.println("questionsStored in checkingservice= " + questionsStored);
        siguiente:   for(AnswerUser au : answers){
                        for(Question q : questionsStored){
                            for(Answer a: q.getAnswers()){
                                if(au.getAnswer()!=null && au.getAnswer().equals(a.getBodyAnswer())){
                                    if(a.isRight()){
                                        count++;
                                    }
                                    break siguiente;
                                }
                            }
                        }
                    }

        return count;
    }
}
