package ao.chimgam.ticket_zone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ao.chimgam.ticket_zone.models.CheckIn;

@Repository 
public interface CheckInRepository extends JpaRepository<CheckIn, Long> {
}