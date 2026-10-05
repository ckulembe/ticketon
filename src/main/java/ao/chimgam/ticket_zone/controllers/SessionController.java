package ao.chimgam.ticket_zone.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ao.chimgam.ticket_zone.models.Session;
import ao.chimgam.ticket_zone.services.SessionService;

@RestController
@RequestMapping("/api/sessions")
public class SessionController extends AbstractCrudController<Session, Long> {

	public SessionController(SessionService service) {
		super(service, Long::valueOf, Session::setId, Session::getId);
	}
}