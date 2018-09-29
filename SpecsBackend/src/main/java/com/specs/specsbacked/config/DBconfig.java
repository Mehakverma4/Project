package com.specs.specsbacked.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.specs.specsbackend.model.Authorization;
import com.specs.specsbackend.model.Category;
import com.specs.specsbackend.model.Customer;
import com.specs.specsbackend.model.Product;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="com.specs")

public class DBconfig {

	@Bean("dataSource")

    public DataSource geth2DataSource()
    {
	
	DriverManagerDataSource dataSource=new DriverManagerDataSource();
	   dataSource.setDriverClassName("org.h2.Driver");
	   dataSource.setUrl("jdbc:h2:tcp://localhost/~/Project");
	   dataSource.setUsername("h2");
	   dataSource.setPassword("h2");
	   return dataSource;
	  
    }
@Autowired
@Bean("sessionFactory")
public SessionFactory getSessionFactory(DataSource dataSource)
{
	 LocalSessionFactoryBuilder sessionFactory=new LocalSessionFactoryBuilder(dataSource);
    sessionFactory.addAnnotatedClass(Category.class);
    sessionFactory.addAnnotatedClass(Product.class);
    sessionFactory.addAnnotatedClass(Customer.class);
    sessionFactory.addAnnotatedClass(Authorization.class);
	 sessionFactory.addProperties(getHibernateProperties());
	 return sessionFactory.buildSessionFactory(); 

}

public Properties getHibernateProperties()
{
	 Properties properties=new Properties();
	 properties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	 properties.setProperty("hibernate.show_sql","true");
	 properties.setProperty("hibernate.hbm2ddl.auto","update");
	 return properties;
	 
}
@Autowired
@Bean("hibernateTransactionManager")
public HibernateTransactionManager geTransactionManager(SessionFactory sessionFactory)
{
   HibernateTransactionManager transactionManager=new HibernateTransactionManager();
   transactionManager.setSessionFactory(sessionFactory);
   return transactionManager;
}





}


