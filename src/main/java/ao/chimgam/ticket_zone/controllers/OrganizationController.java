package ao.chimgam.ticket_zone.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ao.chimgam.ticket_zone.models.Organization;
import ao.chimgam.ticket_zone.services.OrganizationService;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController extends AbstractCrudController<Organization, UUID> {

	public OrganizationController(OrganizationService service) {
		super(service, UUID::fromString, Organization::setId, Organization::getId);
	}
}