package com.example.bbq.backend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.json.JsonSanitizer;

@Service
public class QuestionService {

    @Autowired
    QuestionGenerator questionGenerator;

    public List<QuestionResponse> generateQuestions(String text, int numberOfQuestions) {
        String prompt = "Generiere " + numberOfQuestions
                + " Multiple-Choice-Fragen zu verschiedenen Themen basierend auf dem folgenden Text: "
                + text;

        String response = questionGenerator.generate(prompt);

        response = JsonSanitizer.sanitize(response);

        System.out.println(response);

        List<QuestionResponse> questionResponse = parseJsonResponse(response);
        return questionResponse == null ? new ArrayList<>() : questionResponse;
    }

    public static List<QuestionResponse> parseJsonResponse(String jsonResponse) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonResponse, new TypeReference<List<QuestionResponse>>() {
            });
        } catch (Exception e) {
            System.err.println("Error parsing JSON response: " + e.getMessage());
            return null;
        }
    }
}
