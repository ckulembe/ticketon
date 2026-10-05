package ao.chimgam.ticket_zone.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ao.chimgam.ticket_zone.models.TicketType;
import ao.chimgam.ticket_zone.services.TicketTypeService;

@RestController
@RequestMapping("/api/ticket-types")
public class TicketTypeController extends AbstractCrudController<TicketType, Long> {

	public TicketTypeController(TicketTypeService service) {
		super(service, Long::valueOf, TicketType::setId, TicketType::getId);
	}
}