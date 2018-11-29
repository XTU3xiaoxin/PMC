package com.bcs.tja.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcs.tja.dao.UserDao;
import com.bcs.tja.domain.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User findById(Integer id) {
		
		return userDao.selectByPrimaryKey(id);
	}

	@Override
	public User findByName(String name) {
		return userDao.SelectByName(name);
	}

}
