package ao.chimgam.ticket_zone.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import ao.chimgam.ticket_zone.models.Ticket;
import ao.chimgam.ticket_zone.repositories.TicketRepository;

@Service
public class TicketService extends AbstractCrudService<Ticket, UUID> {
	public TicketService(TicketRepository repository) {
		super(repository);
	}
}