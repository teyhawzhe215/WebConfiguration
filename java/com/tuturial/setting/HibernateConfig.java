package com.tuturial.setting;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.tutorial.entities.User;

import static org.hibernate.cfg.Environment.*;

@Configurable
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class HibernateConfig {

	@Autowired
	private Environment env;
	
	@Bean(name="userSessionFactory")
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();

		
		System.out.println(env.getProperty("mysql.jdbcUrl"));
		
		
		Properties props = new Properties();
		props.put( DRIVER , env.getProperty("mysql.driver") );
		props.put(URL, env.getProperty("mysql.jdbcUrl"));
		props.put(USER, env.getProperty("mysql.username"));
		props.put(PASS, env.getProperty("mysql.password"));
		props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
	    props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
	    
	    //沒有+會出現exception
	    props.put(CURRENT_SESSION_CONTEXT_CLASS, "thread");
	    
	    props.put(FORMAT_SQL,true);

	    props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
	    props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
	    props.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
	    props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
	    props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));
	    
	    localSessionFactoryBean.setHibernateProperties(props);
	    localSessionFactoryBean.setPackagesToScan("com.tutorial.entities");
	    //localSessionFactoryBean.setAnnotatedClasses(User.class);
	   
	    //不然 HibernateTransactionManager getTransactionManager 會錯 感覺是session還沒有建立
	    try {
	    	localSessionFactoryBean.afterPropertiesSet();
	      } catch (IOException e) {
		     e.printStackTrace();
	      }
	    
		return localSessionFactoryBean;
	}
	
	@Bean(name="userTransactionManager")
	public HibernateTransactionManager getTransactionManager() {
		
		HibernateTransactionManager transactionManager =  new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}
	
	@Bean(name="animalGroupSessionFactory")
	public LocalSessionFactoryBean getAnimalGroupSessionFactory() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();

		
		System.out.println(env.getProperty("mysql1.jdbcUrl"));
		
		
		Properties props = new Properties();
		props.put( DRIVER , env.getProperty("mysql.driver") );
		props.put(URL, env.getProperty("mysql1.jdbcUrl"));
		props.put(USER, env.getProperty("mysql.username"));
		props.put(PASS, env.getProperty("mysql.password"));
		props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
	    props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
	    
	    //沒有+會出現exception
	    props.put(CURRENT_SESSION_CONTEXT_CLASS, "thread");
	    
	    props.put(FORMAT_SQL,true);

	    props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
	    props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
	    props.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
	    props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
	    props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));
	    
	    localSessionFactoryBean.setHibernateProperties(props);
	    localSessionFactoryBean.setPackagesToScan("com.tutorial.animalgroup.entities");
	    //localSessionFactoryBean.setAnnotatedClasses(User.class);
	   
	    //不然 HibernateTransactionManager getTransactionManager 會錯 感覺是session還沒有建立
	    try {
	    	localSessionFactoryBean.afterPropertiesSet();
	      } catch (IOException e) {
		     e.printStackTrace();
	      }
	    
		return localSessionFactoryBean;
	}
	
	@Bean(name="animalGroupTransactionManager")
	public HibernateTransactionManager getAnimalGroupTransactionManager() {
		
		HibernateTransactionManager transactionManager =  new HibernateTransactionManager();
		transactionManager.setSessionFactory(getAnimalGroupSessionFactory().getObject());
		return transactionManager;
	}
	
}
