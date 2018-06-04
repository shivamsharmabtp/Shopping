package com.shopping.services;

import org.springframework.context.annotation.Role;

import com.shopping.entity.UserRole;

public interface RoleService {
	 public UserRole getRole(int id);
}
