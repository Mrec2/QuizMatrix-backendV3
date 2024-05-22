package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.service;

import lombok.Getter;
import lombok.Setter;
import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
public class SaveQuestionService {

    private List<Question> myQuestionsStored;


}
