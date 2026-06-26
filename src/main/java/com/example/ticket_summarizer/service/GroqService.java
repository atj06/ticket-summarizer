package com.example.ticketsummarizer.service;

import com.example.ticketsummarizer.dto.AiTicketResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GroqService {

    @Value("${groq.api.key}")
    private String apiKey;

    public String summarizeTicket(String description) {

        String prompt =
                "Analyze this support ticket and return ONLY JSON in this format: " +
                "{\"summary\":\"...\",\"priority\":\"HIGH/MEDIUM/LOW\",\"category\":\"HARDWARE/SOFTWARE\"}. " +
                "Ticket: " + description;
        
        System.out.println("Key loaded: " + apiKey.substring(0, 5));

        String url = "https://api.groq.com/openai/v1/chat/completions";

       String requestBody = """
{
  "model": "llama-3.3-70b-versatile",
  "messages": [
    {
      "role": "user",
      "content": "%s"
    }
  ]
}
""".formatted(
    prompt
        .replace("\\", "\\\\")
        .replace("\"", "\\\"")
        .replace("\n", "\\n")
        .replace("\r", "")
);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        HttpEntity<String> entity =
                new HttpEntity<>(requestBody, headers);

        RestTemplate restTemplate = new RestTemplate();

        System.out.println(requestBody);

        return restTemplate.postForObject(
                url,
                entity,
                String.class
        );
    }

   public AiTicketResponse analyzeTicket(String description) {

    try {
        String groqResponse = summarizeTicket(description);

        ObjectMapper mapper = new ObjectMapper();

        String content = mapper.readTree(groqResponse)
                .get("choices")
                .get(0)
                .get("message")
                .get("content")
                .asText();

        AiTicketResponse response =
                mapper.readValue(content, AiTicketResponse.class);

        return response;

    } catch (Exception e) {
        e.printStackTrace();

        AiTicketResponse response = new AiTicketResponse();
        response.setSummary(description);
        response.setPriority("LOW");
        response.setCategory("SOFTWARE");

        return response;
    }
}
}