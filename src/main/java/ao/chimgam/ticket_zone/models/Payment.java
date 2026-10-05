package ao.chimgam.ticket_zone.models;

import java.math.BigInteger;

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
 * PaymentStatus
 */

enum PaymentStatus {
	
	PENDING("Awaiting Payment"),
	AUTHORIZED("Authorized"),
	PAID("Paid"),
	FAILED("Failed"),
	REFUNDED("Refunded"),
	CHARGEBACK("Chargeback");

    private final String description;

    PaymentStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

/**
 * Payment
 */

@Entity
@Table ( name = "payments" )
public class Payment {

	@Id
	@Column ( name = "payment_id" )
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	private Long id;

	@ManyToOne ( optional = false )
	@JoinColumn ( name = "order_id", nullable = false )
	private Order order;

	@Column 
	private String provider;

	@Column 
	private String providerRef;

	@Column 
	private BigInteger amountMiror;

	@Enumerated ( EnumType.STRING )
	@Column 
	private PaymentStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getProviderRef() {
		return providerRef;
	}

	public void setProviderRef(String providerRef) {
		this.providerRef = providerRef;
	}

	public BigInteger getAmountMiror() {
		return amountMiror;
	}

	public void setAmountMiror(BigInteger amountMiror) {
		this.amountMiror = amountMiror;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}