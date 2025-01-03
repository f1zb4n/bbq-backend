package com.example.bbq.backend;

import lombok.Data;

@Data
public class QuestionRequest {
    private String text;
    private int numberOfQuestions;
}
