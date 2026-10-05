package ao.chimgam.ticket_zone.services;

import org.springframework.stereotype.Service;

import ao.chimgam.ticket_zone.models.Membership;
import ao.chimgam.ticket_zone.repositories.MembershipRepository;

@Service
public class MembershipService extends AbstractCrudService<Membership, Long> {
	public MembershipService(MembershipRepository repository) {
		super(repository);
	}
}