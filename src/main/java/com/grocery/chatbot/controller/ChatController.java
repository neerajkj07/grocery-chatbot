package com.grocery.chatbot.controller;

//import org.springframework.ai.bedrock.anthropic.BedrockAnthropicChatModel;
//import org.springframework.ai.bedrock.anthropic.BedrockTitanChatModel;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ChatController {

    private final ChatClient chatClient;

//    @Bean
//    public ChatClient.Builder chatClientBuilder(ChatModel chatModel) {
//        return ChatClient.builder(chatModel);
//    }

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

    @PostMapping("/content")
    public String content(@RequestBody Map<String, String> request) {
        String message = request.getOrDefault("message", "Tell me an interesting fact about Google Gemini.");
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }

}
