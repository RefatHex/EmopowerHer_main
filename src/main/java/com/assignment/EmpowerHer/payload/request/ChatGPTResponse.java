package com.assignment.EmpowerHer.payload.request;

import com.assignment.EmpowerHer.models.ChatGPTChoice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatGPTResponse {
    private List<ChatGPTChoice> choices;
}
