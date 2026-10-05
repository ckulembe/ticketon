package ao.chimgam.ticket_zone.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Participant
 */

@Entity
@Table ( name = "participants")
public class Participant {

	@Id
	@Column ( name = "participant_id" )
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	private Long id;

	@ManyToOne ( optional = false )
	@JoinColumn ( name = "event_id", nullable = false )
	private Event event;

	@ManyToOne ( optional = false )
	@JoinColumn ( name = "participant_category_id", nullable = false )
	private ParticipantCategory participantCategory;

	@ManyToOne ( optional = true )
	@JoinColumn ( name = "user_id", nullable = true )
	private User user;

	@Column ( nullable = false )
	private String name;

	@Column ( nullable = false )
	private String email;

	@Column ( nullable = true )
	private String phone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public ParticipantCategory getParticipantCategory() {
		return participantCategory;
	}

	public void setParticipantCategory(ParticipantCategory participantCategory) {
		this.participantCategory = participantCategory;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}