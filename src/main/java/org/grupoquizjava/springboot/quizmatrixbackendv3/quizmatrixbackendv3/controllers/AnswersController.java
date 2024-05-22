//package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.controllers;//package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.controllers;
//
//
//
//import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.AnswerUser;
//import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.service.CheckingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.support.SessionStatus;
//
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/answers")
//@CrossOrigin(origins = "*")
//
//public class AnswersController {
//
//    @Autowired
//    CheckingService checkingService;
//
//    @PostMapping
//    public ResponseEntity<Object> answersForResult(@RequestBody List<AnswerUser> answers, @ModelAttribute("questionsForCheck")List<Map<String, Object>> questionsForCheck, SessionStatus status) {
//        System.out.println("Entra en el post de answers?");
////        for (AnswerUser answer : answers) {
////            System.out.println("Answer: " + answer.toString());
////        }
////        return ResponseEntity.ok().body(answers);
//        System.out.println("questionsForCheck " + questionsForCheck);
//        Integer result = checkingService.Score();
//
////        status.setComplete();
//        return ResponseEntity.ok().body(result);
//    }
//}


//package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.controllers;
//
//import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.AnswerUser;
//import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.service.CheckingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.support.SessionStatus;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/answers")
//@CrossOrigin(origins = "*")
//@SessionAttributes("questionsForCheck")
//public class AnswersController {
//
//    @Autowired
//    CheckingService checkingService;
//
//    @PostMapping
//    public ResponseEntity<Object> answersForResult(@RequestBody List<AnswerUser> answers, @ModelAttribute("questionsForCheck") List<Map<String, Object>> questionsForCheck, SessionStatus status) {
//        System.out.println("Entra en el post de answers?");
//        System.out.println("questionsForCheck " + questionsForCheck);
//
//        // Aquí podrías usar las preguntas almacenadas en questionsForCheck y las respuestas proporcionadas para calcular el resultado
//        Integer result = checkingService.Score();
//
//        // Limpiar la sesión después de procesar las respuestas
//        status.setComplete();
//
//        return ResponseEntity.ok().body(result);
//    }
//}


package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.controllers;

import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.AnswerUser;
import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.service.CheckingService;
import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.service.SaveQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
@CrossOrigin(origins = "*")
public class AnswersController {



    @Autowired
    CheckingService checkingService;

    @Autowired
    SaveQuestionService saveQuestionService;


    @PostMapping
    public ResponseEntity<Object> answersForResult(@RequestBody List<AnswerUser> answers) {

        Integer result = null ;
//        System.out.println("Entra en el post de answers?");
//        System.out.println("My old questions : " + saveQuestionService.getMyQuestionsStored());
        result = checkingService.score(answers, saveQuestionService.getMyQuestionsStored());
//        System.out.println("result of sending to Frontend = " + result);

        return ResponseEntity.ok().body(result);
    }
}



