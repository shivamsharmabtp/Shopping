package com.shopping.dao;

import java.util.List;

import com.shopping.entity.ProductCategory;


public interface ProductCategoryDao {

	ProductCategory get(int id);
	List<ProductCategory> list();
	boolean add(ProductCategory category);
	boolean update(ProductCategory category);
	boolean delete(ProductCategory category);
}
