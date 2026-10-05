package ao.chimgam.ticket_zone.services;

import org.springframework.stereotype.Service;

import ao.chimgam.ticket_zone.models.Participant;
import ao.chimgam.ticket_zone.repositories.ParticipantRepository;

@Service
public class ParticipantService extends AbstractCrudService<Participant, Long> {
	public ParticipantService(ParticipantRepository repository) {
		super(repository);
	}
}