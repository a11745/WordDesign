package com.home.serviceImpl;

import com.home.dao.LoginDao;
import com.home.daoImpl.LoginDaoImpl;
import com.home.domain.User;
import com.home.service.LoginService;

public class LoginServiceImpl implements LoginService {

	@Override
	public User login(String username,String password) {
		LoginDao loginDao = new LoginDaoImpl();
		User user = loginDao.login(username,password);
		return user;
	}
	@Override
	public Boolean register(String username, String password) {
		LoginDao loginDao = new LoginDaoImpl();
		User user = loginDao.register(username,password);
		if (user==null) {
			int i = loginDao.registerss(username, password);
			if (i>0) {
				return true;
			}else {
				return false;
			}
			
		}
		return false;
	}

}
