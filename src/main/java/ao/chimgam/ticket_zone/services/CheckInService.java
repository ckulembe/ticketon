package ao.chimgam.ticket_zone.services;

import org.springframework.stereotype.Service;

import ao.chimgam.ticket_zone.models.CheckIn;
import ao.chimgam.ticket_zone.repositories.CheckInRepository;

@Service
public class CheckInService extends AbstractCrudService<CheckIn, Long> {
	public CheckInService(CheckInRepository repository) {
		super(repository);
	}
}