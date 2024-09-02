package com.assignment.EmpowerHer.security.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class GeminiApiService {

    @Value("${gemini.api.key}")
    private String apiKey;

    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent";

    public String queryText(String prompt) throws IOException {
        // Create the parts map
        Map<String, Object> parts = new HashMap<>();
        parts.put("text", prompt);

        // Create the contents map
        Map<String, Object> contents = new HashMap<>();
        contents.put("parts", new Map[]{parts});

        // Create the request payload map
        Map<String, Object> requestPayload = new HashMap<>();
        requestPayload.put("contents", new Map[]{contents});

        // Convert the request payload to JSON
        String jsonPayload = new ObjectMapper().writeValueAsString(requestPayload);

        // Create the headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create the HTTP entity with the JSON payload and headers
        HttpEntity<String> entity = new HttpEntity<>(jsonPayload, headers);

        // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Make the HTTP POST request and get the response
        ResponseEntity<String> responseEntity = restTemplate.exchange(API_URL + "?key=" + apiKey, HttpMethod.POST, entity, String.class);

        // Extract the response body
        String responseBody = responseEntity.getBody();

        // Log the response body for debugging
        System.out.println("Response Body: " + responseBody);

        return responseBody;
    }
}
