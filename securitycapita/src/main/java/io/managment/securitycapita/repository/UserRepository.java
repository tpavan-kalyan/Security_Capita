package io.managment.securitycapita.repository;

import java.util.Collection;

import io.managment.securitycapita.domain.User;

public interface UserRepository<T extends User> {

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

}
