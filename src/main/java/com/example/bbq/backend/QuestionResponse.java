package com.example.bbq.backend;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class QuestionResponse {
    private String question;
    private Map<String, String> options;
    private String correctAnswer;
}