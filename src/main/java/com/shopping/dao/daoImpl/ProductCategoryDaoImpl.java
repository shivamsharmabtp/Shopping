package com.shopping.dao.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.shopping.dao.ProductCategoryDao;
import com.shopping.entity.ProductCategory;


public class ProductCategoryDaoImpl implements ProductCategoryDao{
	@Autowired
	private SessionFactory sessionFactory;

	
	public List<ProductCategory> list() {
		
		String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("active", true);
						
		return query.getResultList();
	}

	/*
	 * Getting single category based on id
	 */
	
	public ProductCategory get(int id) {

		return sessionFactory.getCurrentSession().get(ProductCategory.class, Integer.valueOf(id));

	}

	

	public boolean add(ProductCategory category) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	/*
	 * Updating a single category
	 */
	
	public boolean update(ProductCategory category) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	
	public boolean delete(ProductCategory category) {
		
		//category.setActive(false);
		
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
