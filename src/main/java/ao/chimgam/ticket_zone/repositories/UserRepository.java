package ao.chimgam.ticket_zone.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ao.chimgam.ticket_zone.models.User;

@Repository 
public interface UserRepository extends JpaRepository<User, UUID> {

	Optional<User> findByEmailIgnoreCase(String email);
	List<User> findByNameContainingIgnoreCase(String name);
	boolean existsByEmailIgnoreCase(String email);
	
}