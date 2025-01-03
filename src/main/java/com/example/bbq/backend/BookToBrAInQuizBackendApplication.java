package com.example.bbq.backend;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;

@SpringBootApplication
public class BookToBrAInQuizBackendApplication {

	@Bean
	ChatLanguageModel chatLanguageModel() {
		return OllamaChatModel.builder()
				.baseUrl("http://localhost:7869")
				.modelName("llama3.2:3b")
				.temperature(0.0)
				.timeout(Duration.ofMinutes(2))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(BookToBrAInQuizBackendApplication.class, args);
	}

}
