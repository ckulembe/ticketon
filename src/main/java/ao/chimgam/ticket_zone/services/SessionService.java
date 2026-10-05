package ao.chimgam.ticket_zone.services;

import org.springframework.stereotype.Service;

import ao.chimgam.ticket_zone.models.Session;
import ao.chimgam.ticket_zone.repositories.SessionRepository;

@Service
public class SessionService extends AbstractCrudService<Session, Long> {
	public SessionService(SessionRepository repository) {
		super(repository);
	}
}