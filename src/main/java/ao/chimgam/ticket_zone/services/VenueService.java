package ao.chimgam.ticket_zone.services;

import org.springframework.stereotype.Service;

import ao.chimgam.ticket_zone.models.Venue;
import ao.chimgam.ticket_zone.repositories.VenueRepository;

@Service
public class VenueService extends AbstractCrudService<Venue, Long> {
	public VenueService(VenueRepository repository) {
		super(repository);
	}

}