package com.assignment.EmpowerHer.security.services;

import com.assignment.EmpowerHer.payload.request.ChatGPTRequest;
import com.assignment.EmpowerHer.payload.request.ChatGPTResponse;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ChatGPTService {

    @Value("${OPEN_AI_MODEL}")
    private String model;

    @Value("${OPEN_AI_TEMPERATURE}")
    private int temperature;

    @Value("${OPEN_AI_MAX_TOKENS}")
    private int maxTokens;

    @Value("${OPEN_AI_URL}")
    private String url;

    @Value("${OPEN_AI_KEY}")
    private String key;


    public String processSearch(String query) {
        ChatGPTRequest chatGPTRequest = ChatGPTRequest.builder()
                .model(model)
                .temperature(temperature)
                .prompt(query)
                .maxTokens(maxTokens)
                .build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("Authorization", "Bearer " + key);
        Gson gson = new Gson();
        String body = gson.toJson(chatGPTRequest);
        log.info("body: " + body);
        try {
            final StringEntity entity = new StringEntity(body);
            httpPost.setEntity(entity);
            try(CloseableHttpClient httpClient = HttpClients.custom().build();
                CloseableHttpResponse response = httpClient.execute(httpPost)) {
                String responseBody = EntityUtils.toString(response.getEntity());
                log.info("Raw API Response: " + responseBody);
                ChatGPTResponse chatGPTResponse = gson.fromJson(responseBody, ChatGPTResponse.class);
                return chatGPTResponse.getChoices().get(0).getText();
            } catch (Exception e) {
                return e.getMessage();
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
