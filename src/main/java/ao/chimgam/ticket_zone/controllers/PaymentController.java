package ao.chimgam.ticket_zone.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ao.chimgam.ticket_zone.models.Payment;
import ao.chimgam.ticket_zone.services.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController extends AbstractCrudController<Payment, Long> {

	public PaymentController(PaymentService service) {
		super(service, Long::valueOf, Payment::setId, Payment::getId);
	}
}