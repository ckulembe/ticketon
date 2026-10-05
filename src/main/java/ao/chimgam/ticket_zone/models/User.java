package ao.chimgam.ticket_zone.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * User
 */

@Entity 
@Table ( name = "users" )
public class User {

	@Id 
	@Column ( name = "user_id" )
	@GeneratedValue ( strategy = GenerationType.UUID )
	private UUID id;

	@Column ( nullable = false )
	private String email;

	@Column ( nullable = false )
	private String name;

	@Column ( nullable = true )
	private String phone;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}