package ao.chimgam.ticket_zone.services;

import org.springframework.stereotype.Service;

import ao.chimgam.ticket_zone.models.TicketType;
import ao.chimgam.ticket_zone.repositories.TicketTypeRepository;

@Service
public class TicketTypeService extends AbstractCrudService<TicketType, Long> {
	public TicketTypeService(TicketTypeRepository repository) {
		super(repository);
	}
}