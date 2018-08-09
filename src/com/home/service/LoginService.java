package com.home.service;

import com.home.domain.User;

public interface LoginService {

	public User login(String username,String password);
	public Boolean register(String username,String password);
}
