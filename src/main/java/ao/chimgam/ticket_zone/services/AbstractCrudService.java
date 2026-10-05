package ao.chimgam.ticket_zone.services;

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractCrudService<T, ID> {

	private final JpaRepository<T, ID> repository;

	protected AbstractCrudService(JpaRepository<T, ID> repository) {
		this.repository = repository;
	}

	@Transactional(readOnly = true)
	public List<T> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public Optional<T> findById(ID id) {
		return repository.findById(id);
	}

	@Transactional
	public T create(T entity) {
		validateForSave(entity, null);
		return repository.save(entity);
	}

	@Transactional
	public Optional<T> update(ID id, T entity, BiConsumer<T, ID> idSetter) {
		if (!repository.existsById(id)) {
			return Optional.empty();
		}

		idSetter.accept(entity, id);
		validateForSave(entity, id);
		return Optional.of(repository.save(entity));
	}

	protected void validateForSave(T entity, ID id) {
	}

	@Transactional
	public boolean deleteById(ID id) {
		if (!repository.existsById(id)) {
			return false;
		}

		repository.deleteById(id);
		return true;
	}
}