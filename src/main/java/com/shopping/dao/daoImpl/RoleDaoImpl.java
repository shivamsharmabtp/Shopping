package com.shopping.dao.daoImpl;



import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.dao.RoleDao;
import com.shopping.entity.UserRole;
@Transactional
@Repository
public class RoleDaoImpl implements RoleDao {
     
    @Autowired
    private SessionFactory sessionFactory;
     
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
 
    public UserRole getRole(int id) {
        UserRole role =  getCurrentSession().load(UserRole.class, id);
        return role;
    }

	public UserRole findRoleByRoleNAme(String role) {
		Session session = sessionFactory.getCurrentSession();
		 Criteria crit = session.createCriteria(UserRole.class);
		 crit.add(Restrictions.eq("role", role));
		 return (UserRole) crit.uniqueResult();
	}
 
}