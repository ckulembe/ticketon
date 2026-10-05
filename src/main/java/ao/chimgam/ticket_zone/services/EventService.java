package ao.chimgam.ticket_zone.services;

import java.util.UUID;
import java.time.OffsetDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ao.chimgam.ticket_zone.models.Event;
import ao.chimgam.ticket_zone.repositories.EventRepository;

@Service
public class EventService extends AbstractCrudService<Event, UUID> {
	private final EventRepository repository;

	public EventService(EventRepository repository) {
		super(repository);
		this.repository = repository;
	}

	public Optional<Event> findBySlug(String slug) {
		return repository.findBySlug(slug);
	}

	@Override
	protected void validateForSave(Event event, UUID id) {
		OffsetDateTime startsAt = event.getStartAt();
		OffsetDateTime endsAt = event.getEndsAt();
		if (startsAt == null || endsAt == null || !endsAt.isAfter(startsAt)) {
			throw new InvalidEventException("Event end time must be after its start time");
		}

		String slug = event.getSlug();
		if (slug == null || slug.isBlank()) {
			throw new InvalidEventException("Event slug must not be blank");
		}

		boolean slugUsed = id == null
				? repository.existsBySlug(slug)
				: repository.existsBySlugAndIdNot(slug, id);
		if (slugUsed) {
			throw new DuplicateEventSlugException(slug);
		}
	}

	public static class InvalidEventException extends RuntimeException {
		public InvalidEventException(String message) {
			super(message);
		}
	}

	public static class DuplicateEventSlugException extends RuntimeException {
		public DuplicateEventSlugException(String slug) {
			super("An event with slug '" + slug + "' already exists");
		}
	}
}