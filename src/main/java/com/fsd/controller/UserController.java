package com.fsd.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
