package io.managment.securitycapita.dtomapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import io.managment.securitycapita.domain.User;
import io.managment.securitycapita.dto.UserDTO;

@Component
public class UserDTOMapper 
{
	public static UserDTO fromUser(User user) {
		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(user, userDTO);
		return userDTO;
	}
	
	public static User toUser(UserDTO userDTO) {
		User user = new User();
		BeanUtils.copyProperties(userDTO, user);
		return user;
	}
}
