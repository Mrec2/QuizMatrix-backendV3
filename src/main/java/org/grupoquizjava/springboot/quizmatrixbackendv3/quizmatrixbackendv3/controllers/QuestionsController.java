package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


// THIS IS ONLY A TESTING BETWEEN BACK AND FRONT AND MAKE SOMETHING CSS IN THE FRONTEND. JPA-HIBERNATE IS ALMOST DONE. ONCE HIBERNATE WAS IMPLEMENTED, THIS TEST WILL BE DELETED AND IT WILL WORKING WITH THE NEW FEATURES.

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "*")
public class QuestionsController {

    @PostMapping("/{language}")
    public ResponseEntity<Object> getQuestions(@PathVariable String language) {
        String messageTest = "This is Working nice";
        System.out.println("messageTest = " + messageTest);
        System.out.println("The language that you select is " + language);

        // Simulating test

        List<Map<String, Object>> myQuestions = new ArrayList<>();

        for (int x = 1; x <= 25; x++) {
            Map<String, Object> question = createQuestion(x);
            myQuestions.add(question);
        }

        System.out.println("questions = " + myQuestions);

        return ResponseEntity.ok().body(myQuestions);
    }

    // Create question, only for test
    private Map<String, Object> createQuestion(int index) {
        Map<String, Object> question = new HashMap<>();
        List<String> bodyOptions = Arrays.asList("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut.", "Lorem ipsum dolor sit amet.");
        question.put("bodyOptions", bodyOptions);
        question.put("question", "¿Cómo es la forma correcta de declarar e inicializar una variable en JavaScript, teniendo en cuenta el Scope Local " + index + " ?");
        return question;
    }
}
