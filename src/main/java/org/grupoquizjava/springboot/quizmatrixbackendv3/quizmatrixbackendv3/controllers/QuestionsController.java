package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins= "*")
public class QuestionsController {

    @PostMapping("/{language}")
    public ResponseEntity <String> getQuestions (@PathVariable String language) {
    String messageTest = "This is Working nice";
        System.out.println("messageTest = " + messageTest);
        System.out.println("The language that you select is " + language);

//        return ResponseEntity.ok().body(messageTest);
        return null;
    }
}
