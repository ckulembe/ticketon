package ao.chimgam.ticket_zone.models;

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

/**
 * OrgRole
 */

enum OrgRole {

	OWNER("Owner"),
	ADMIN("Administrator"),
	MEMBER("Member"),
	GUEST("Guest");

	private final String description;

	OrgRole(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}

/**
 * Membership
 */

@Entity 
@Table ( name = "memberships", uniqueConstraints = {
		@UniqueConstraint ( name = "uk_membership_user_organization", columnNames = { "user_id", "organization_id" } )
} )
public class Membership {

	@Id
	@Column ( name = "membership_id" )
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	private Long id;

	@ManyToOne ( optional = false )
	@JoinColumn ( name = "user_id", nullable = false )
	private User user;

	@ManyToOne ( optional = false )
	@JoinColumn ( name = "organization_id", nullable = false )
	private Organization organization;

	@Enumerated ( EnumType.STRING )
	@Column ( nullable = false )
	private OrgRole role;

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organizationId) {
		this.organization = organizationId;
	}

	public OrgRole getRole() {
		return role;
	}

	public void setRole(OrgRole role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}