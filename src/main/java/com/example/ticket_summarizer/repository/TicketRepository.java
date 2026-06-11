package com.example.ticketsummarizer.repository;

import com.example.ticketsummarizer.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}