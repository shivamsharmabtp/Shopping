package com.shopping.dao;



import com.shopping.entity.User;

public interface UserDao {
	User findByUserName(String username);
	public void saveUser(User user);
}
