package ao.chimgam.ticket_zone.services;

import org.springframework.stereotype.Service;

import ao.chimgam.ticket_zone.models.ParticipantCategory;
import ao.chimgam.ticket_zone.repositories.ParticipantCategoryRepository;

@Service
public class ParticipantCategoryService extends AbstractCrudService<ParticipantCategory, Long> {
	public ParticipantCategoryService(ParticipantCategoryRepository repository) {
		super(repository);
	}
}