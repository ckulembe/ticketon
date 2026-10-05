package ao.chimgam.ticket_zone.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ao.chimgam.ticket_zone.models.Event;
import ao.chimgam.ticket_zone.repositories.EventRepository;

class EventServiceTest {

	private EventRepository repository;
	private EventService service;

	@BeforeEach
	void setUp() {
		repository = org.mockito.Mockito.mock(EventRepository.class);
		service = new EventService(repository);
	}

	@Test
	void findBySlugReturnsRepositoryResult() {
		Event event = validEvent("music-festival");
		when(repository.findBySlug("music-festival")).thenReturn(Optional.of(event));

		assertSame(event, service.findBySlug("music-festival").orElseThrow());
	}

	@Test
	void createRejectsEndTimeThatIsNotAfterStartTime() {
		Event event = validEvent("music-festival");
		event.setEndsAt(event.getStartAt());

		assertThrows(EventService.InvalidEventException.class, () -> service.create(event));
	}

	@Test
	void createRejectsDuplicateSlug() {
		Event event = validEvent("music-festival");
		when(repository.existsBySlug("music-festival")).thenReturn(true);

		assertThrows(EventService.DuplicateEventSlugException.class, () -> service.create(event));
	}

	@Test
	void updateAllowsKeepingTheCurrentSlug() {
		UUID id = UUID.randomUUID();
		Event event = validEvent("music-festival");
		when(repository.existsById(id)).thenReturn(true);
		when(repository.existsBySlugAndIdNot("music-festival", id)).thenReturn(false);
		when(repository.save(any(Event.class))).thenAnswer(invocation -> invocation.getArgument(0));

		Event updated = service.update(id, event, Event::setId).orElseThrow();

		assertEquals(id, updated.getId());
		verify(repository).existsBySlugAndIdNot("music-festival", id);
	}

	private Event validEvent(String slug) {
		Event event = new Event();
		event.setSlug(slug);
		event.setStartAt(OffsetDateTime.parse("2026-11-01T10:00:00Z"));
		event.setEndsAt(OffsetDateTime.parse("2026-11-01T12:00:00Z"));
		return event;
	}
}