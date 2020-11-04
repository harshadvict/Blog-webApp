package dao;

import model.User;

public interface userDaoInterface {
	int signup(User user);
	boolean loginUser(User user);
}
