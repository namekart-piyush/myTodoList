package com.piyushSingh.myTodoList.config;

import com.piyushSingh.myTodoList.DTO.geminiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "geminiClient", url = "https://generativelanguage.googleapis.com/v1beta")
public interface  GeminiFeignClient {
    @PostMapping(value = "/models/gemini-1.5-flash:generateContent")
    ResponseEntity<?> getTaskSuggestions(@RequestParam("key") String apiKey, @RequestBody String request);
}
