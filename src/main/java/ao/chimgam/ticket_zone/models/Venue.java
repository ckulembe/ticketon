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
 * Venue
 */

@Entity 
@Table ( name = "venues" )
public class Venue {

	@Id 
	@Column ( name = "venue_id" )
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	private Long id;

	@ManyToOne ( optional = false )
	@JoinColumn ( name = "organization_id", nullable = false )
	private Organization organization;

	@Column ( nullable = false )
	private String name;

	@Column ( nullable = false )
	private String address;

	@Column ( nullable = false )
	private float latitude;

	@Column ( nullable = false )
	private float longitude;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}