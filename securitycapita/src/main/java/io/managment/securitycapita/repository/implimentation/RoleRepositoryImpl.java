package io.managment.securitycapita.repository.implimentation;

import static io.managment.securitycapita.enums.RoleType.ROLE_USER;
import static io.managment.securitycapita.query.RoleQuery.*;

import java.util.Collection;
import static java.util.Map.*;
import static java.util.Objects.*;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import io.managment.securitycapita.domain.Role;
import io.managment.securitycapita.exception.ApiException;
import io.managment.securitycapita.repository.RoleRepository;
import io.managment.securitycapita.rowmapper.RoleRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Slf4j
public class RoleRepositoryImpl implements RoleRepository<Role>{

	
	private final NamedParameterJdbcTemplate jdbc;
	
	
	@Override
	public Role create(Role data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Role> list(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role update(Role data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRoleToUser(Long userId, String roleName) 
	{
		log.info("Adding role {} to User id: {} "+ roleName, userId );
	
		try {
			
			Role role = jdbc.queryForObject(SELECT_ROLE_BY_NAME_QUERY, of("roleName", roleName), new RoleRowMapper());
			jdbc.update(INSERTROLE_TO_USER_QUERY, of("userId", userId, "roleId", requireNonNull(role).getId()));
			
		} catch (EmptyResultDataAccessException exception) {
			// TODO: handle exception
			throw new ApiException("No role found by name: "+ ROLE_USER.name());
	
		}catch (Exception exception) {
			// TODO: handle exception			
			throw new ApiException("An error occured. Please try again!");

		}
		
	}

	@Override
	public Role getRoleByUserId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role getRoleByUserEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUserRole(Long id, String roleName) {
		// TODO Auto-generated method stub
		
	}

}
