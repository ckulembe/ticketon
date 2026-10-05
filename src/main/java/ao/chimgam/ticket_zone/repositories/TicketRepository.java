package ao.chimgam.ticket_zone.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ao.chimgam.ticket_zone.models.Ticket;

@Repository 
public interface TicketRepository extends JpaRepository<Ticket, UUID> {
}