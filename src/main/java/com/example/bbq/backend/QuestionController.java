// src/main/java/com/example/quizapp/controller/QuestionController.java
package com.example.bbq.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/questions")
    public ResponseEntity<List<QuestionResponse>> generateQuestions(@RequestBody QuestionRequest request) {
        List<QuestionResponse> questions = questionService.generateQuestions(request.getText(),
                request.getNumberOfQuestions());
        return ResponseEntity.ok(questions);
    }
}
