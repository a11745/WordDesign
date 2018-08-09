package com.home.dao;

import com.home.domain.User;

public interface LoginDao {
	public User login(String username,String password);
	public User register(String username,String password);
	public int registerss(String username,String password);
}
