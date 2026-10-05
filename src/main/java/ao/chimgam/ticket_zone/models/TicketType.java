package ao.chimgam.ticket_zone.models;

import java.math.BigInteger;
import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * TicketType
 */

@Entity 
@Table ( name = "ticket_types")
public class TicketType {

	@Id 
	@Column ( name = "ticket_type_id")
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	private Long id;

	@ManyToOne ( optional = false )
	@JoinColumn ( name = "event_id", nullable = false )
	private Event event;

	@Column 
	private String name;

	@Column 
	private BigInteger priceMiror;

	@Column 
	private char currency;

	@Column 
	private int	quota;

	@Column 
	private int sold;

	@Column 
	private int maxPerOrder;

	@Column 
	private OffsetDateTime salesStart;

	@Column 
	private OffsetDateTime salesEnd;

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

	public BigInteger getPriceMiror() {
		return priceMiror;
	}

	public void setPriceMiror(BigInteger priceMiror) {
		this.priceMiror = priceMiror;
	}

	public char getCurrency() {
		return currency;
	}

	public void setCurrency(char currency) {
		this.currency = currency;
	}

	public int getQuota() {
		return quota;
	}

	public void setQuota(int quota) {
		this.quota = quota;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public int getMaxPerOrder() {
		return maxPerOrder;
	}

	public void setMaxPerOrder(int maxPerOrder) {
		this.maxPerOrder = maxPerOrder;
	}

	public OffsetDateTime getSalesStart() {
		return salesStart;
	}

	public void setSalesStart(OffsetDateTime salesStart) {
		this.salesStart = salesStart;
	}

	public OffsetDateTime getSalesEnd() {
		return salesEnd;
	}

	public void setSalesEnd(OffsetDateTime salesEnd) {
		this.salesEnd = salesEnd;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}