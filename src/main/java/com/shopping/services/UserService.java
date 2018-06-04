package com.shopping.services;

import java.util.List;

import com.shopping.entity.User;

public interface UserService {
    /*User findById(int id);
	
	User findByUserName(String userName);
	void saveUser(User user);
    
    void updateUser(User user);
     
    void deleteUserByUserName(String userName);
 
    List<User> findAllUsers(); 
     */
   // boolean isUserSSOUnique(Integer id, String sso);
    public User getUser(String login);
}
