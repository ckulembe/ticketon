package ao.chimgam.ticket_zone.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import ao.chimgam.ticket_zone.models.Organization;
import ao.chimgam.ticket_zone.repositories.OrganizationRepository;

@Service
public class OrganizationService extends AbstractCrudService<Organization, UUID> {
	public OrganizationService(OrganizationRepository repository) {
		super(repository);
	}
}