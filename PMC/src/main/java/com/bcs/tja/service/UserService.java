package com.bcs.tja.service;

import com.bcs.tja.domain.User;

public interface UserService {

	User findById(Integer id);
	
	User findByName(String name);
}
