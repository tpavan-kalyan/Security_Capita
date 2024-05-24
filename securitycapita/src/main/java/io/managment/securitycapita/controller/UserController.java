package io.managment.securitycapita.controller;

import static java.time.LocalDateTime.*;

import static java.util.Map.*;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.managment.securitycapita.domain.HttpResponse;
import io.managment.securitycapita.domain.User;
import io.managment.securitycapita.dto.UserDTO;
import io.managment.securitycapita.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController 
{
	private final UserService userService;
	
	@PostMapping("path")
	public ResponseEntity<HttpResponse> saveUser(@RequestBody @Valid User user) {
		UserDTO userDTO = userService.createUser(user);
		return ResponseEntity.created(getUri()).body(
				HttpResponse.builder()
				.timeStamp(now().toString())
				.data(of("user", userDTO))
				.message("User Created")
				.status(HttpStatus.CREATED)
				.statusCode(HttpStatus.CREATED.value())
				.build()
				);
	}

	private URI getUri() {
		return URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("user/get/<userId>").toUriString());
	}
	
	
}
