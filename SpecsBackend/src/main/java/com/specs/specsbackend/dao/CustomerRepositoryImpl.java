package com.specs.specsbackend.dao;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.specs.specsbackend.model.Authorization;
import com.specs.specsbackend.model.Customer;

@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {

	@Autowired
	private SessionFactory sessionFactory;
	public boolean addCustomer(Customer customer) {
		
		Session session=sessionFactory.getCurrentSession();
		try {
		session.save(customer);
		Authorization auth=new Authorization();
		auth.setUserName(customer.getEmailId());
		session.save(auth);
		
		
		
		return true;
	}
catch(HibernateException e)
{
	e.printStackTrace();
	return false;
	
}
}
}