package com.example.ticketsummarizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.ticketsummarizer")
public class TicketSummarizerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketSummarizerApplication.class, args);
    }
}