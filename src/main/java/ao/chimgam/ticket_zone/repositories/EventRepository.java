package ao.chimgam.ticket_zone.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ao.chimgam.ticket_zone.models.Event;

@Repository 
public interface EventRepository extends JpaRepository<Event, UUID> {

	Optional<Event> findBySlug(String slug);

	boolean existsBySlug(String slug);

	boolean existsBySlugAndIdNot(String slug, UUID id);
}