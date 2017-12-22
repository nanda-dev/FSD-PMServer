package com.fsd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.dto.PmAPIResponseDTO;
import com.fsd.dto.UserDTO;
import com.fsd.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/api/user", method = RequestMethod.GET)
	public List<UserDTO> getAllUsers() {
		//log.debug("getAllUsers");
		return userService.getAllUsers();
	}
	
	@RequestMapping(value = "/api/user", method = RequestMethod.POST)
	public PmAPIResponseDTO addUser(@RequestBody UserDTO newUser) {		
		return userService.addUser(newUser);
	}
	
	@RequestMapping(value = "/api/user", method = RequestMethod.PUT)
	public UserDTO editUser(@RequestBody UserDTO user) {		
		return userService.updateUser(user);
	}
	
	@RequestMapping(value = "/api/user", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id) {
		String result = (userService.deleteUser(id) ? "Success" : "Failed");
		return result;
	}

}
