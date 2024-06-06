package io.managment.securitycapita.service;

import io.managment.securitycapita.domain.User;
import io.managment.securitycapita.dto.UserDTO;

public interface UserService 
{
	UserDTO createUser(User user); 
}
