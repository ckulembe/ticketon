package ao.chimgam.ticket_zone.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ao.chimgam.ticket_zone.models.Ticket;
import ao.chimgam.ticket_zone.services.TicketService;

@RestController
@RequestMapping("/api/tickets")
public class TicketController extends AbstractCrudController<Ticket, UUID> {

	public TicketController(TicketService service) {
		super(service, UUID::fromString, Ticket::setId, Ticket::getId);
	}
}