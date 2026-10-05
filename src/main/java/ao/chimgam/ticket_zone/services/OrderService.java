package ao.chimgam.ticket_zone.services;

import org.springframework.stereotype.Service;

import ao.chimgam.ticket_zone.models.Order;
import ao.chimgam.ticket_zone.repositories.OrderRepository;

@Service
public class OrderService extends AbstractCrudService<Order, Long> {
	public OrderService(OrderRepository repository) {
		super(repository);
	}
}