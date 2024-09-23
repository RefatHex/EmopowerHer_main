package com.assignment.EmpowerHer.security.services;

import com.assignment.EmpowerHer.payload.request.SearchAIRequest;
import com.assignment.EmpowerHer.payload.request.SearchAIResponse;
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
public class SearchAIService {

    @Value("${external.api.url}")
    private String url;

    public SearchAIResponse processSearch(String query) throws Exception {
        // Creating SearchAIRequest
        SearchAIRequest chatRequest = SearchAIRequest.builder()
                .prompt(query)
                .build();

        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json");

        Gson gson = new Gson();
        String body = gson.toJson(chatRequest);
        log.info("Request body: " + body);

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            final StringEntity entity = new StringEntity(body);
            httpPost.setEntity(entity);

            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                String responseBody = EntityUtils.toString(response.getEntity());
                log.info("Raw API Response: " + responseBody);

                // Parse the API response to SearchAIResponse
                return gson.fromJson(responseBody, SearchAIResponse.class);
            }
        } catch (Exception e) {
            log.error("Error executing API call", e);
            throw new Exception("API call failed: " + e.getMessage(), e);
        }
    }
}
