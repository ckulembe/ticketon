package ao.chimgam.ticket_zone.controllers;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ao.chimgam.ticket_zone.models.Event;
import ao.chimgam.ticket_zone.services.EventService;

@RestController
@RequestMapping("/api/events")
public class EventController extends AbstractCrudController<Event, UUID> {
	private final EventService eventService;

	public EventController(EventService service) {
		super(service, UUID::fromString, Event::setId, Event::getId);
		this.eventService = service;
	}

	@GetMapping("/slug/{slug}")
	public ResponseEntity<Event> findBySlug(@PathVariable String slug) {
		return eventService.findBySlug(slug)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@ExceptionHandler(EventService.DuplicateEventSlugException.class)
	public ResponseEntity<String> handleDuplicateSlug(EventService.DuplicateEventSlugException exception) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
	}

	@ExceptionHandler(EventService.InvalidEventException.class)
	public ResponseEntity<String> handleInvalidEvent(EventService.InvalidEventException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
}