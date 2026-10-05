package ao.chimgam.ticket_zone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ao.chimgam.ticket_zone.models.ParticipantCategory;

@Repository 
public interface ParticipantCategoryRepository extends JpaRepository<ParticipantCategory, Long> {
}