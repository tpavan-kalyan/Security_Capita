package io.managment.securitycapita.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

import java.time.LocalDateTime;;

@Data
@AllArgsConstructor
@JsonInclude(NON_DEFAULT)
@SuperBuilder
@NoArgsConstructor
public class User 
{
	private Long id;
	@NotEmpty(message = "First name cannot be empty")
	private String firstName;
	@NotEmpty(message = "Last name cannot be empty")
	private String lastName;
	@NotEmpty(message = "Email name cannot be empty")
	@Email(message = "Invalid email. Please enter a valid email address")
	private String email;
	@NotEmpty(message = "Password name cannot be empty")
	private String password;
	private String address;
	private String phone;
	private String title;
	private String bio;
	private String imageUrl;
	private boolean enable;
	private boolean isNotLocked;
	private boolean isUsingMfa;
	private LocalDateTime createdAt;
	
}
