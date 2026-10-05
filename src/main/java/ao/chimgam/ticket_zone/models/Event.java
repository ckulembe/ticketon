package ao.chimgam.ticket_zone.models;

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
import jakarta.persistence.UniqueConstraint;

import java.time.OffsetDateTime;

/**
 * EventStatus
 */

enum EventStatus {

	SCHEDULED("Planned"),
	ONGOING("In Progress"),
	COMPLETED("Finished"),
	CANCELLED("Aborted"),
	POSTPONED("Delayed");
	
	private final String description;

	EventStatus ( String description ) {
		this.description = description;
	}

	public String getString() {
		return description;
	}
}

/**
 * Event
 */

@Entity 
@Table ( name = "events", uniqueConstraints = {
		@UniqueConstraint ( name = "uk_events_slug", columnNames = "slug" )
} )
public class Event {

	@Id
	@Column ( name = "event_id" )
	@GeneratedValue ( strategy = GenerationType.UUID )
	private UUID id;

	@ManyToOne ( optional = true )
	@JoinColumn ( name = "venue_id", nullable = true )
	private Venue venue;

	@ManyToOne ( optional = false )
	@JoinColumn ( name = "organization_id", nullable = false )
	private Organization organization;

	@Column ( nullable = false )
	private String title;

	@Column ( nullable = false )
	private String slug;

	@Column ( nullable = false )
	private String timezone;

	@Enumerated ( EnumType.STRING )
	@Column ( nullable = false )
	private EventStatus status;

	@Column ( nullable = false )
	private OffsetDateTime startAt;

	@Column ( nullable = false )
	private OffsetDateTime endsAt;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public OffsetDateTime getStartAt() {
		return startAt;
	}

	public void setStartAt(OffsetDateTime startAt) {
		this.startAt = startAt;
	}

	public OffsetDateTime getEndsAt() {
		return endsAt;
	}

	public void setEndsAt(OffsetDateTime endsAt) {
		this.endsAt = endsAt;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public EventStatus getStatus() {
		return status;
	}

	public void setStatus(EventStatus status) {
		this.status = status;
	}
	
}