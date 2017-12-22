package com.fsd.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.dao.UserDAO;
import com.fsd.dto.PmAPIResponseDTO;
import com.fsd.dto.UserDTO;
import com.fsd.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDao;
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/* (non-Javadoc)
	 * @see com.fsd.service.UserService#getAllUsers()
	 */
	@Override
	public List<UserDTO> getAllUsers() {
		LOGGER.debug("in getAllUsers...");
		ArrayList<User> userObjs = ( ArrayList<User>) userDao.findAll();
		
		List<UserDTO> users = transformUsers(userObjs);
		
		return users;
	}	
	

	@Override
	public PmAPIResponseDTO addUser(UserDTO newUser) {	
		PmAPIResponseDTO response = new PmAPIResponseDTO();
		try {
			User userObj = transformUser(newUser);
			userObj.setStatus("Y");
			userDao.saveAndFlush(userObj);
			
		} catch(Exception e) {
			response.setStatus("failure");
			response.setMessage("Error while adding user: " + e.getLocalizedMessage());
		}
		return response;
	}
	
	@Override
	public UserDTO updateUser(UserDTO user) {
		User userObj = userDao.findOne(user.getId());
		if(userObj != null) {
			userObj = transformUser(user);
		}
		userDao.saveAndFlush(userObj);
		return user;
	}
	
	@Override
	public boolean deleteUser(Long id) {
		boolean result = false;
		User userObj = userDao.findOne(id);
		if(userObj != null) {
			//userDao.delete(userObj);
			userObj.setStatus("N");
			userDao.saveAndFlush(userObj);
			result = true;
		}
		
		return result;
	}
	
	private List<UserDTO> transformUsers(ArrayList<User> userObjs) {
		List<UserDTO> userList = new ArrayList<>();		
		for(User user : userObjs) {
			UserDTO usr = new UserDTO();
			usr.setId(user.getId());
			usr.setFirstName(user.getFirstName());
			usr.setLastName(user.getLastName());
			userList.add(usr);
		}		
		return userList;
	}
	
	private User transformUser(UserDTO user) {
		User userObj = new User();
		
		userObj.setId(user.getId());
		userObj.setFirstName(user.getFirstName());
		userObj.setLastName(user.getLastName());		
		
		return userObj;
	}
	
	private List<UserDTO> getUsersMock() {
		List<UserDTO> users = new ArrayList<>();
		
		UserDTO user1 = new UserDTO();
		user1.setId(1L);
		user1.setFirstName("Test User1");
		user1.setLastName("Lastname");
				
		UserDTO user2 = new UserDTO();
		user2.setId(2L);
		user2.setFirstName("Test User2");
		user2.setLastName("Lastname");
		
		users.add(user1);
		users.add(user2);
		
		return users;
	}
}
