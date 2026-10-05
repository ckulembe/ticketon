package ao.chimgam.ticket_zone.models;

import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * TicketStatus
 */
enum TicketStatus {

	OPEN("Open"),
	ASSIGNED("Assigned"),
	IN_PROGRESS("In Progress"),
	PENDING_CUSTOMER("Pending Customer Reply"),
	RESOLVED("Resolved"),
	CLOSED("Closed");

	private final String description;

	TicketStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}

/**
 * Ticket
 */

@Entity 
@Table ( name = "tickets" )
public class Ticket {

	@Id 
	@Column ( name = "ticket_id")
	@GeneratedValue ( strategy = GenerationType.UUID )
	private UUID id;

	@ManyToOne ( optional = false )
	@JoinColumn ( name = "ticket_type_id", nullable = false )
	private TicketType ticketType;

	@ManyToOne ( optional = false )
	@JoinColumn ( name = "order_id", nullable = false )
	private Order order;

	@ManyToOne ( optional = true )
	@JoinColumn ( name = "participant_id", nullable = true )
	private Participant participant;

	@Column ( nullable = false )
	private String code;

	@Enumerated ( EnumType.STRING )
	@Column ( nullable = false )
	private TicketStatus status;

	@Column ( nullable = false )
	private OffsetDateTime issuedAt;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public TicketStatus getStatus() {
		return status;
	}

	public void setStatus(TicketStatus status) {
		this.status = status;
	}

	public OffsetDateTime getIssuedAt() {
		return issuedAt;
	}

	public void setIssuedAt(OffsetDateTime issuedAt) {
		this.issuedAt = issuedAt;
	}

	public TicketType getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

}