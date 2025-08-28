package vn.host.service;

import vn.host.model.User;

public interface UserService {
	User login(String username, String password);
	User get(String username);
}
