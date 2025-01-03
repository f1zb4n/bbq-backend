package com.example.bbq.backend;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface QuestionGenerator {

    @SystemMessage("""
            Du bist ein JSON-Generator. Deine Aufgabe ist es, basierend auf einem Text eine
            gewünschte Anzahl von Multiple-Choice-Frage zu erstellen und diese als Ausgabe zurückzugeben.
            Beachte dabei die folgenden Regeln:

            1. Die Antwort muss exakt im JSON-Format sein, damit sie direkt von einem JSON-Parser verarbeitet werden kann.
            2. Es dürfen keine zusätzlichen Erklärungen, Kommentare oder Leerzeilen enthalten sein.
            3. Füge keine Escape-Zeichen hinzu, es sei denn, sie sind notwendig.
            4. Die Position der richtigen Antwort soll von Frage zu Frage variieren, damit man kein Muster erkennen kann.

            Gib die JSON-Ausgabe im folgenden Format zurück:

            [
                {
                    'question': '<Die generierte Frage>',
                    'options': {
                        'A': '<Option A>',
                        'B': '<Option B>',
                        'C': '<Option C>',
                        'D': '<Option D>'
                    },
                    'correctAnswer': '<Die richtige Option (A, B, C oder D)>'
                },
            ]
            """)

    String generate(String userMessage);
}
