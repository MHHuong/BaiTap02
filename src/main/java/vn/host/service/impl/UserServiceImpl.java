package vn.host.service.impl;

import vn.host.dao.UserDao;
import vn.host.dao.impl.UserDaoImpl;
import vn.host.model.User;
import vn.host.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();

	@Override
	public User login(String username, String password) {
		User user = this.get(username);
		if (user != null && password.equals(user.getPassWord())) {
			return user;
		}
		return null;
	}

	@Override
	public User get(String username) {
		return userDao.get(username);
	}
}
