package com.shopping.services.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.dao.UserDao;
import com.shopping.entity.User;
import com.shopping.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
     
    @Autowired
    private UserDao userDao;

	public User getUser(String login) {
		// TODO Auto-generated method stub
		return null;
	}
 
    /*public User getUser(String login) {
        return userDao.getUser(login);
    }*/
 
}