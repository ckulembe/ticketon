package ao.chimgam.ticket_zone.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity 
@Table ( name = "ticket_type_sessions", uniqueConstraints = {
		@UniqueConstraint ( name = "uk_ticket_type_session", columnNames = { "ticket_type_id", "session_id" } )
} )
public class TicketTypeSession {

	@Id 
	@Column ( name = "ticket_type_session_id" )
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	private Long id;

	@ManyToOne ( optional = false )
	@JoinColumn ( name = "ticket_type_id", nullable = false )
	private TicketType ticketType;

	@ManyToOne ( optional = false )
	@JoinColumn ( name = "session_id", nullable = false )
	private Session session;

	public TicketType getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
