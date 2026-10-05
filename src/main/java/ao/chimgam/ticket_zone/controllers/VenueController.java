package ao.chimgam.ticket_zone.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ao.chimgam.ticket_zone.models.Venue;
import ao.chimgam.ticket_zone.services.VenueService;

@RestController
@RequestMapping("/api/venues")
public class VenueController extends AbstractCrudController<Venue, Long> {

	public VenueController(VenueService service) {
		super(service, Long::valueOf, Venue::setId, Venue::getId);
	}
}