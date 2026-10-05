package ao.chimgam.ticket_zone.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ao.chimgam.ticket_zone.models.Participant;
import ao.chimgam.ticket_zone.services.ParticipantService;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController extends AbstractCrudController<Participant, Long> {

	public ParticipantController(ParticipantService service) {
		super(service, Long::valueOf, Participant::setId, Participant::getId);
	}
}