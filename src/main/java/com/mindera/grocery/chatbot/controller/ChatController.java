package com.mindera.grocery.chatbot.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/chat")
    public ChatResponse chat() {
        return chatClient.prompt().
                user("Tell me an interesting fact about Google Gemini.").call().chatResponse();
    }

    @PostMapping("/bot")
    public ChatResponse bot(@RequestBody Map<String, String> request) {
        String message = request.getOrDefault("message", "Tell me an interesting fact about Google Gemini.");
        return chatClient.prompt()
                .user(message)
                .call()
                .chatResponse();
    }

}
