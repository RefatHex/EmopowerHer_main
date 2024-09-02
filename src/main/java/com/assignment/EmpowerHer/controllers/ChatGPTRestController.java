package com.assignment.EmpowerHer.controllers;


import com.assignment.EmpowerHer.payload.request.SearchRequest;
import com.assignment.EmpowerHer.security.services.ChatGPTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api")
public class ChatGPTRestController {
    private final ChatGPTService chatGPTService;

    public ChatGPTRestController(ChatGPTService chatGPTService) {
        this.chatGPTService = chatGPTService;
    }

    @PostMapping("/searchChatGPT")
    public String searchChatGPT(@RequestBody SearchRequest searchRequest) {
        log.info("searchGPT: Started query: " + searchRequest.getQuery());
        return chatGPTService.processSearch(searchRequest.getQuery());
    }
}
