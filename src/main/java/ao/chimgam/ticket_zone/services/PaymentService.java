package ao.chimgam.ticket_zone.services;

import org.springframework.stereotype.Service;

import ao.chimgam.ticket_zone.models.Payment;
import ao.chimgam.ticket_zone.repositories.PaymentRepository;

@Service
public class PaymentService extends AbstractCrudService<Payment, Long> {
	public PaymentService(PaymentRepository repository) {
		super(repository);
	}
}