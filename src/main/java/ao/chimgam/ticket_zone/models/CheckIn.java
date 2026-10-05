package ao.chimgam.ticket_zone.models;

import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * CheckIn
 */

@Entity 
@Table ( name = "checkins" )
public class CheckIn {

	@Id 
	@Column ( name = "checkin_id" )
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	private Long id;

	@ManyToOne ( optional = false )
	@JoinColumn ( name = "session_id", nullable = false )
	private Session session;

	@ManyToOne ( optional = false )
	@JoinColumn ( name = "ticket_id", nullable = false )
	private Ticket ticket;

	@Column ( nullable = false )
	private OffsetDateTime scannedAt;

	@Column ( nullable = false )
	private UUID scannedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OffsetDateTime getScannedAt() {
		return scannedAt;
	}

	public void setScannedAt(OffsetDateTime scannedAt) {
		this.scannedAt = scannedAt;
	}

	public UUID getScannedBy() {
		return scannedBy;
	}

	public void setScannedBy(UUID scannedBy) {
		this.scannedBy = scannedBy;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

}