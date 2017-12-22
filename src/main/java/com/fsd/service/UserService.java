package com.fsd.service;

import java.util.List;

import com.fsd.dto.UserDTO;

public interface UserService {

	List<UserDTO> getAllUsers();

	UserDTO addUser(UserDTO newUser);

	UserDTO updateUser(UserDTO user);

	boolean deleteUser(Long id);

}