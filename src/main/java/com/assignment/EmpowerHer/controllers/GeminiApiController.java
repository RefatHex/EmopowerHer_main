package com.assignment.EmpowerHer.controllers;

import com.assignment.EmpowerHer.security.services.GeminiApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class GeminiApiController {

    @Autowired
    private GeminiApiService geminiApiService;

    @PostMapping("/query-text")
    public ResponseEntity<String> queryText(@RequestParam("prompt") String prompt) {
        try {
            String response = geminiApiService.queryText(prompt);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to process text prompt", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
