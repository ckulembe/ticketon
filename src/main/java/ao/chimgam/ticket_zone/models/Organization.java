package ao.chimgam.ticket_zone.models;


import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Organization
 */

@Entity
@Table ( name = "organizations" )
public class Organization {

	@Id
	@Column ( name = "organization_id" )
	@GeneratedValue ( strategy = GenerationType.UUID )
	private UUID id;

	@Column ( nullable = false )
	private String name;

	@Column ( nullable = false )
	private String slug;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

}