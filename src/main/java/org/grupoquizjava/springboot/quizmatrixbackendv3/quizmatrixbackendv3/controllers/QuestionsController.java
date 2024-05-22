//package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.controllers;
//
//import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.service.QuestionService;
//import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.util.QuestionsBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//
//@RestController
//@RequestMapping("/api/questions")
//@CrossOrigin(origins = "*")
//@SessionAttributes({"questionsForCheck"})
//public class QuestionsController {
//
//    @Autowired
//    QuestionService questionService;
//
//    List<Map<String, Object>> myQuestions;
//
//    @Autowired
//    QuestionsBuilder questionsBuilder;
//
//    @ModelAttribute("questionsForCheck")
//    public List<Map<String, Object>> getStoredQuestions () {
//        return new ArrayList<>();
//    }
//    @PostMapping("/{language}")
//    public ResponseEntity<Object> getQuestions(@PathVariable String language, @ModelAttribute("questionsForCheck") List<Map<String, Object>> questionsForCheck) {
//        questionsForCheck = questionsBuilder.getqBuilder(questionService, language);
//
//        System.out.println("myQuestions = " + questionsForCheck);
//        return ResponseEntity.ok().body(questionsForCheck);
//
//    }
//
//}


//package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.controllers;
//
//import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.service.QuestionService;
//import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.util.QuestionsBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//import java.util.*;
//
//
//
//// ***** Problems with Session for storing data!!!
//
//
//@RestController
//@RequestMapping("/api/questions")
//@CrossOrigin(origins = "*")
//@SessionAttributes("questionsForCheck")
//public class QuestionsController {
//
//    @Autowired
//    QuestionService questionService;
//
//    @Autowired
//    QuestionsBuilder questionsBuilder;
//
//    @ModelAttribute("questionsForCheck")
//    public List<Map<String, Object>> initializeQuestionsForCheck() {
//        return new ArrayList<>();
//    }
//
//    @PostMapping("/{language}")
//    public ResponseEntity<Object> getQuestions(@PathVariable String language, @ModelAttribute("questionsForCheck") List<Map<String, Object>> questionsForCheck) {
//        List<Map<String, Object>> myQuestions = questionsBuilder.getqBuilder(questionService, language);
//        questionsForCheck.clear();
//        questionsForCheck.addAll(myQuestions);
//
//        System.out.println("myQuestions = " + myQuestions);
//        return ResponseEntity.ok().body(myQuestions);
//    }
//}


package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.controllers;

import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.Question;
import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.service.QuestionService;
import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.service.SaveQuestionService;
import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.util.QuestionsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "*")
public class QuestionsController {



    @Autowired
    QuestionService questionService;

    @Autowired
    QuestionsBuilder questionsBuilder;

    @Autowired
    SaveQuestionService saveQuestionService;

    @PostMapping("/{language}")
    public ResponseEntity<Object> getQuestions(@PathVariable String language) {
        List<Map<String, Object>> myQuestions = questionsBuilder.getqBuilder(questionService, language);
        List<Question> questionList = questionsBuilder.getQuestions();
        saveQuestionService.setMyQuestionsStored(questionList);

        return ResponseEntity.ok().body(myQuestions);

    }

}

