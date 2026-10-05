package ao.chimgam.ticket_zone.services;

import org.springframework.stereotype.Service;

import ao.chimgam.ticket_zone.models.TicketTypeSession;
import ao.chimgam.ticket_zone.repositories.TicketTypeSessionRepository;

@Service
public class TicketTypeSessionService extends AbstractCrudService<TicketTypeSession, Long> {
	public TicketTypeSessionService(TicketTypeSessionRepository repository) {
		super(repository);
	}
}