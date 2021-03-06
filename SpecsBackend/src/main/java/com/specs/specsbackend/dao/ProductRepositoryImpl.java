package com.specs.specsbackend.dao;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.specs.specsbackend.model.Product;
@Repository
@Transactional

public class ProductRepositoryImpl implements ProductRepository {
	@Autowired
	private SessionFactory sessionFactory;
		public boolean addProduct(Product product) {
			 Session session=sessionFactory.getCurrentSession();
			 try {
				 session.save(product);
				 return true;
			 }
			 catch (HibernateException e) {
				 e.printStackTrace();
			 
			 return false;
			 } 
		
			
		}

		public boolean updateProduct(Product product) {
			// TODO Auto-generated method stub
			Session session=sessionFactory.getCurrentSession();
			try {
				session.update(product);
				return true;
			}
			catch(HibernateException e)
			{
			e.printStackTrace();
				return false;
		}}

		public boolean deleteProduct(int productId) {
			// TODO Auto-generated method stub
			Session session=sessionFactory.getCurrentSession();
			try {
				session.delete(getProductById(productId));
				return true;
				
			}
			catch(HibernateException e) {
				e.printStackTrace();
				return false;
			}
			
		}

		public List<Product> getAllProduct() {
			// TODO Auto-generated method stub
			Session session=sessionFactory.getCurrentSession();
			try {
				Query query=session.createQuery("from Product");
				List<Product>productList=(List<Product>)query.getResultList();
				return productList;
			}
			catch(HibernateException e) {
			return null;
		}}

		public Product getProductById(int productId) {
			// TODO Auto-generated method stub
			Session session=sessionFactory.getCurrentSession();
			try {
				Product product=(Product)session.get(Product.class,productId);
				return product;
			}
			catch(HibernateException e) {
				
				e.printStackTrace();
				return null;
				
			}
			
			
			
		}

	}


