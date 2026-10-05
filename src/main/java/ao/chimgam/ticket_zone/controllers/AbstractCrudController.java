package ao.chimgam.ticket_zone.controllers;

import java.net.URI;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ao.chimgam.ticket_zone.services.AbstractCrudService;

public abstract class AbstractCrudController<T, ID> {

	protected final AbstractCrudService<T, ID> service;
	private final Function<String, ID> idParser;
	private final BiConsumer<T, ID> idSetter;
	private final Function<T, ID> idGetter;

	protected AbstractCrudController(
			AbstractCrudService<T, ID> service,
			Function<String, ID> idParser,
			BiConsumer<T, ID> idSetter,
			Function<T, ID> idGetter) {
		this.service = service;
		this.idParser = idParser;
		this.idSetter = idSetter;
		this.idGetter = idGetter;
	}

	@GetMapping
	public List<T> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<T> findById(@PathVariable String id) {
		return service.findById(parseId(id))
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<T> create(@RequestBody T entity) {
		T saved = service.create(entity);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(idGetter.apply(saved))
				.toUri();
		return ResponseEntity.created(location).body(saved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<T> update(@PathVariable String id, @RequestBody T entity) {
		ID parsedId = parseId(id);
		return service.update(parsedId, entity, idSetter)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		ID parsedId = parseId(id);
		if (!service.deleteById(parsedId)) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.noContent().build();
	}

	private ID parseId(String rawId) {
		try {
			return idParser.apply(rawId);
		} catch (IllegalArgumentException exception) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid resource ID", exception);
		}
	}
}