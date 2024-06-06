package io.managment.securitycapita.repository;

import java.util.Collection;

import io.managment.securitycapita.domain.Role;

public interface RoleRepository <T extends Role> {

	/*
	 * Basic CURD Operations
	 */
	
	T create(T data);
	Collection<T> list(int page, int pageSize);
	T get(Long id);
	T update(T data);
	Boolean delete(Long id);
	
	/*
	 * More Complex Operations
	 */
	void addRoleToUser(Long userId, String roleName);
	
	Role getRoleByUserId(Long id);
	
	Role getRoleByUserEmail(String email);
	
	void updateUserRole(Long id, String roleName);

}