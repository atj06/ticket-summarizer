package com.example.ticketsummarizer.controller;

import com.example.ticketsummarizer.dto.TicketRequest;
import com.example.ticketsummarizer.entity.Ticket;
import com.example.ticketsummarizer.service.GroqService;
import com.example.ticketsummarizer.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService service;

    @Autowired
    private GroqService groqService;

    @PostMapping
    public Ticket createTicket(@RequestBody TicketRequest request) {
        return service.createTicket(request.getDescription());
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return service.getAllTickets();
    }

    @PostMapping("/ai")
    public String testAi(@RequestBody TicketRequest request) {
        return groqService.summarizeTicket(
                request.getDescription()
        );
    }

    @GetMapping("/test")
    public String test() {
        return "Controller Working";
    }
}