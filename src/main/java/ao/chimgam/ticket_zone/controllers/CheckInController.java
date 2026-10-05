package ao.chimgam.ticket_zone.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ao.chimgam.ticket_zone.models.CheckIn;
import ao.chimgam.ticket_zone.services.CheckInService;

@RestController
@RequestMapping("/api/check-ins")
public class CheckInController extends AbstractCrudController<CheckIn, Long> {

	public CheckInController(CheckInService service) {
		super(service, Long::valueOf, CheckIn::setId, CheckIn::getId);
	}
}