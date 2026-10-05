package ao.chimgam.ticket_zone.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ao.chimgam.ticket_zone.models.Membership;
import ao.chimgam.ticket_zone.services.MembershipService;

@RestController
@RequestMapping("/api/memberships")
public class MembershipController extends AbstractCrudController<Membership, Long> {

	public MembershipController(MembershipService service) {
		super(service, Long::valueOf, Membership::setId, Membership::getId);
	}
}