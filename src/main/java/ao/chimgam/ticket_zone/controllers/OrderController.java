package ao.chimgam.ticket_zone.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ao.chimgam.ticket_zone.models.Order;
import ao.chimgam.ticket_zone.services.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController extends AbstractCrudController<Order, Long> {

	public OrderController(OrderService service) {
		super(service, Long::valueOf, Order::setId, Order::getId);
	}
}