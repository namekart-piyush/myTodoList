package com.piyushSingh.myTodoList.Controller;

import com.piyushSingh.myTodoList.config.GeminiFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/gemini")
public class GeminiController {
    @Autowired
    private GeminiFeignClient geminiFeignClient;

    @PostMapping("/suggest-tasks")
    public ResponseEntity<?> suggestTasks(@RequestBody List<String> todos) {
        try {
            String apiKey = System.getenv("Key"); // Make sure this environment variable is correctly set
            String input = constructJson(todos);
            return ResponseEntity.ok(geminiFeignClient.getTaskSuggestions(apiKey, input));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Gemini controller failed: " + e.getMessage());
        }
    }

    private String constructJson(List<String> todos) {
        // Construct JSON string from todos
        return "{\"contents\": [{\"parts\": [{\"text\": \"" + String.join(", ", todos) + "\"}]}]}";
    }
}
