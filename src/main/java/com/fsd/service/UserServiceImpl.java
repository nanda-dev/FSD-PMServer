package com.fsd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fsd.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	/* (non-Javadoc)
	 * @see com.fsd.service.UserService#getAllUsers()
	 */
	@Override
	public List<UserDTO> getAllUsers() {
		List<UserDTO> users = new ArrayList<>();
		
		UserDTO user1 = new UserDTO();
		user1.setId(1L);
		user1.setFirstName("Test User1");
		user1.setLastName("Lastname");
		user1.setEmpId("10001");
		
		UserDTO user2 = new UserDTO();
		user2.setId(2L);
		user2.setFirstName("Test User2");
		user2.setLastName("Lastname");
		user2.setEmpId("10002");
		
		users.add(user1);
		users.add(user2);
		
		return users;
	}
}
