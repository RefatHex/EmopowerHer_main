package com.assignment.EmpowerHer.payload.request;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatGPTRequest {
    private String model;
    private String prompt;
    private int temperature;

    @SerializedName(value = "max_tokens")
    private int maxTokens;
}
