package ao.chimgam.ticket_zone.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import ao.chimgam.ticket_zone.models.User;
import ao.chimgam.ticket_zone.repositories.UserRepository;

@Service
public class UserService extends AbstractCrudService<User, UUID> {
	private final UserRepository repository;

	public UserService(UserRepository repository) {
		super(repository);
		this.repository = repository;
	}

	public Optional<User> findByEmail( String email )	{
		return repository.findByEmailIgnoreCase(email);
	}

	public List<User> searchByName( String name )	{
		return repository.findByNameContainingIgnoreCase(name.trim());
	}

	public boolean existByEmail( String email )	{
		return repository.existsByEmailIgnoreCase(email);
	}
}