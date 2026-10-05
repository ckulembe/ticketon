package ao.chimgam.ticket_zone.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ao.chimgam.ticket_zone.models.ParticipantCategory;
import ao.chimgam.ticket_zone.services.ParticipantCategoryService;

@RestController
@RequestMapping("/api/participant-categories")
public class ParticipantCategoryController extends AbstractCrudController<ParticipantCategory, Long> {

	public ParticipantCategoryController(ParticipantCategoryService service) {
		super(service, Long::valueOf, ParticipantCategory::setId, ParticipantCategory::getId);
	}
}