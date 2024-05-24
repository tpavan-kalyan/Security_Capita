package io.managment.securitycapita.repository.implimentation;

import static io.managment.securitycapita.enums.RoleType.*;
import static io.managment.securitycapita.enums.VerificationType.*;
import static io.managment.securitycapita.query.UserQuery.*;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.managment.securitycapita.domain.Role;
import io.managment.securitycapita.domain.User;
import io.managment.securitycapita.exception.ApiException;
import io.managment.securitycapita.repository.RoleRepository;
import io.managment.securitycapita.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryImpl implements UserRepository<User>
{

	private final NamedParameterJdbcTemplate jdbc;
	private final RoleRepository<Role> roleRepository;
	private final BCryptPasswordEncoder encoder;
	
	@Override
	public User create(User user) {
		
		// check the email is unique
		
		if(getEmailCount(user.getEmail().trim().toLowerCase())>0) throw new ApiException("Email already in use. Please use different email and try again!");
		
		// Save new user
		try {
			
			KeyHolder keyHolder = new GeneratedKeyHolder();
			
			SqlParameterSource parameterSource = getSqlParameterSourse(user);
			
			jdbc.update(INSERT_USER_QUERY, parameterSource, keyHolder);
			
			user.setId(Objects.requireNonNull(keyHolder.getKey().longValue()));
			// Add role to the user
			roleRepository.addRoleToUser(user.getId(), ROLE_USER.name());
			
			// Send verification URL
			String verificationUrl = getVerificationUrl(UUID.randomUUID().toString(), ACCOUNT.getType());
			
			// Save URL in verification table
			jdbc.update(INSERT_ACCOUNT_VERIFICATION_URL_QUERY, Map.of("userId", user.getId(), "url", verificationUrl));
			
			// Send email to user with verification URL
			//emailService.sendVerificationUrl(user.getFirstName(), user.getEmail(), verificationUrl, ACCOUNT)
			user.setEnable(false);
			user.setNotLocked(true);
			
			// Return the newly created User
			return user;
			// If any errors, throw an Exception with proper message
			
			
		} 
		catch (Exception exception) {
			// TODO: handle exception			
			throw new ApiException("An error occured. Please try again!");

		}
		
	}

	@Override
	public Collection<User> list(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Integer getEmailCount(String email) {
		return jdbc.queryForObject(COUNT_USER_EMAIL_QUERY, Map.of("email", email), Integer.class);
	}
	
	private SqlParameterSource getSqlParameterSourse(User user) {
		// TODO Auto-generated method stub
		return new MapSqlParameterSource()
				.addValue("firstName", user.getFirstName())
				.addValue("lastName", user.getLastName())
				.addValue("email", user.getEmail())
				.addValue("email", encoder.encode(user.getPassword()));
	}
	
	private String getVerificationUrl(String key, String type) {
		return ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/verify"+type+"/"+key).toUriString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
