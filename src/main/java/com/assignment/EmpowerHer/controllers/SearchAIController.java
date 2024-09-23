package com.assignment.EmpowerHer.controllers;

import com.assignment.EmpowerHer.payload.request.SearchAIRequest;
import com.assignment.EmpowerHer.payload.request.SearchAIResponse;
import com.assignment.EmpowerHer.security.services.SearchAIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SearchAIController {

    private static final Logger log = LoggerFactory.getLogger(SearchAIController.class);

    @Autowired
    private SearchAIService searchAIService;

    @PostMapping("/search")
    public ResponseEntity<SearchAIResponse> search(@RequestBody SearchAIRequest chatGPTRequest) {
        log.info("searchGPT: Started query: " + chatGPTRequest.getPrompt());
        try {
            SearchAIResponse response = searchAIService.processSearch(chatGPTRequest.getPrompt());
            log.info("searchGPT: Completed query successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("searchGPT: Error during query processing", e);
            return ResponseEntity.status(500).body(new SearchAIResponse("Error: " + e.getMessage()));
        }
    }
}
