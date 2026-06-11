package com.example.ticketsummarizer.service;

import com.example.ticketsummarizer.dto.AiTicketResponse;
import com.example.ticketsummarizer.entity.Ticket;
import com.example.ticketsummarizer.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository repository;

    @Autowired
    private GroqService groqService;

    public Ticket saveTicket(Ticket ticket) {
        return repository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return repository.findAll();
    }

    public Ticket createTicket(String description) {

        AiTicketResponse response =
                groqService.analyzeTicket(description);

        Ticket ticket = new Ticket();

        ticket.setSummary(response.getSummary());
        ticket.setPriority(response.getPriority());
        ticket.setCategory(response.getCategory());

        return repository.save(ticket);
    }
}