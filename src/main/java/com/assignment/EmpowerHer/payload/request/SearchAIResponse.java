package com.assignment.EmpowerHer.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchAIResponse {
    private String result;

    // Getter and setter
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
