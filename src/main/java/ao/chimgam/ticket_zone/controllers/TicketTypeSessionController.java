package ao.chimgam.ticket_zone.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ao.chimgam.ticket_zone.models.TicketTypeSession;
import ao.chimgam.ticket_zone.services.TicketTypeSessionService;

@RestController
@RequestMapping("/api/ticket-type-sessions")
public class TicketTypeSessionController extends AbstractCrudController<TicketTypeSession, Long> {

	public TicketTypeSessionController(TicketTypeSessionService service) {
		super(service, Long::valueOf, TicketTypeSession::setId, TicketTypeSession::getId);
	}
}