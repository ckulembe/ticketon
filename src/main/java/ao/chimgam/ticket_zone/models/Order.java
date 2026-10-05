package ao.chimgam.ticket_zone.models;

import java.math.BigInteger;
import java.time.OffsetDateTime;

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
 * Orderstatus
 */

enum OrderStatus {

	PAID( "Paid" ),
	PENDING( "Awaiting Payment" ),
	SHIPPED( "Shipped" ),
	DELIVERED( "Delivered" ),
	CANCELLED( "Cancelled" );

	private final String description;

	OrderStatus( String description )	{
		this.description = description;
	}

	public String getDescription()	{
		return this.description;
	}

}

/**
 * Order
 */

@Entity
@Table ( name = "orders" )
public class Order {

	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	@Column ( name = "order_id" )
	private Long id;

	@ManyToOne ( optional = false )
	@JoinColumn ( name = "user_id", nullable = false )
	private User user;

	@ManyToOne ( optional = false )
	@JoinColumn ( name = "event_id", nullable = false )
	private Event event;

	@Enumerated ( EnumType.STRING )
	@Column ( nullable = false ) 
	private OrderStatus status;

	@Column ( nullable = false )
	private BigInteger totalMinor;

	@Column ( nullable = false )
	private OffsetDateTime expiresAt;

	@Column ( nullable = false )
	private OffsetDateTime paidAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public BigInteger getTotalMinor() {
		return totalMinor;
	}

	public void setTotalMinor(BigInteger totalMinor) {
		this.totalMinor = totalMinor;
	}

	public OffsetDateTime getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(OffsetDateTime expiresAt) {
		this.expiresAt = expiresAt;
	}

	public OffsetDateTime getPaidAt() {
		return paidAt;
	}

	public void setPaidAt(OffsetDateTime paidAt) {
		this.paidAt = paidAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}