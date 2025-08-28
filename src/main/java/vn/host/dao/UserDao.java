package vn.host.dao;

import vn.host.model.User;

public interface UserDao {
	User get(String username);
	
}
