package com.shopping.services.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Service;

import com.shopping.dao.RoleDao;
import com.shopping.entity.UserRole;
import com.shopping.services.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
     
    @Autowired
    private RoleDao roleDao;
 
    public UserRole getRole(int id) {
        return roleDao.getRole(id);
    }
 
}