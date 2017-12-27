package com.fsd.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.dto.PmAPIResponseDTO;
import com.fsd.dto.UserDTO;
import com.fsd.service.UserService;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	UserService userService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@CrossOrigin
	@RequestMapping(value = "/api/user", method = RequestMethod.GET)
	public List<UserDTO> getAllUsers() {
		LOGGER.debug("API Invoked: getAllUsers");
		return userService.getAllUsers();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/user", method = RequestMethod.POST)
	public PmAPIResponseDTO addUser(@RequestBody UserDTO newUser) {		
		LOGGER.debug("API Invoked: addUser");
		return userService.addUser(newUser);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/user", method = RequestMethod.PUT)
	public UserDTO editUser(@RequestBody UserDTO user) {	
		LOGGER.debug("API Invoked: editUser");
		return userService.updateUser(user);
	}
	
	@RequestMapping(value = "/api/user/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id) {
		LOGGER.debug("API Invoked: deleteUser");
		String result = (userService.deleteUser(id) ? "Success" : "Failed");
		return result;
	}

}
