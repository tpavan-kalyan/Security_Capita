package io.managment.securitycapita.service.implimentation;

import org.springframework.stereotype.Service;

import io.managment.securitycapita.domain.User;
import io.managment.securitycapita.dto.UserDTO;
import io.managment.securitycapita.dtomapper.UserDTOMapper;
import io.managment.securitycapita.repository.UserRepository;
import io.managment.securitycapita.service.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	
	private UserRepository<User> userRepository;
	
	@Override
	public UserDTO createUser(User user) {
		// TODO Auto-generated method stub
		return UserDTOMapper.fromUser(userRepository.create(user));
	}

}
