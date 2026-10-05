package ao.chimgam.ticket_zone.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ao.chimgam.ticket_zone.models.User;
import ao.chimgam.ticket_zone.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController extends AbstractCrudController<User, UUID> {
	private final UserService userService;

	public UserController(UserService service) {
		super(service, UUID::fromString, User::setId, User::getId);
		this.userService = service;
	}

	@GetMapping("/by-email")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		return userService.findByEmail(email.trim())
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@GetMapping("/search")
	public List<User> searchByName(@RequestParam String name) {
		return userService.searchByName(name);
	}

}