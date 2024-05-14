package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


// THIS IS ONLY A TESTING BETWEEN BACK AND FRONT AND MAKE SOMETHING CSS IN THE FRONTEND. JPA-HIBERNATE IS ALMOST DONE. ONCE HIBERNATE WAS IMPLEMENTED, THIS TEST WILL BE DELETED AND IT WILL WORKING WITH THE NEW FEATURES.

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "*")
public class QuestionsController {

//    @PostMapping("/{language}")
    @GetMapping("/{language}")
    public ResponseEntity<Object> getQuestions(@PathVariable String language) {
        String messageTest = "This is Working nice";
        System.out.println("messageTest = " + messageTest);
        System.out.println("The language that you select is " + language);

        // Simulating test

        List<Map<String, Object>> myQuestions = new ArrayList<>();

        for (int x = 1; x <= 10; x++) {
            Map<String, Object> question = createQuestion(x);
            myQuestions.add(question);
        }

        System.out.println("questions = " + myQuestions);

        return ResponseEntity.ok().body(myQuestions);
    }

    // Create question, only for test
    private Map<String, Object> createQuestion(int index) {
        Map<String, Object> question = new HashMap<>();
        List<String> bodyOptions = Arrays.asList("Option 1", "Option 2", "Option 3", "Option 4");
        question.put("bodyOptions", bodyOptions);
        question.put("question", "Who you are " + index + " ?");
        return question;
    }
}
