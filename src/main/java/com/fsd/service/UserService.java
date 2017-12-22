package com.fsd.service;

import java.util.List;

import com.fsd.dto.PmAPIResponseDTO;
import com.fsd.dto.UserDTO;

public interface UserService {

	List<UserDTO> getAllUsers();

	PmAPIResponseDTO addUser(UserDTO newUser);

	UserDTO updateUser(UserDTO user);

	boolean deleteUser(Long id);

}