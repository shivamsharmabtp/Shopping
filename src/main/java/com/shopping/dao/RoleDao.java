package com.shopping.dao;
import org.springframework.context.annotation.Role;

import com.shopping.entity.*;
public interface RoleDao {
	public UserRole getRole(int id);
	public UserRole findRoleByRoleNAme(String role);
}
