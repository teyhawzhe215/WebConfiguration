package com.tuturial.setting;

import static org.hibernate.cfg.AvailableSettings.C3P0_ACQUIRE_INCREMENT;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_STATEMENTS;
import static org.hibernate.cfg.AvailableSettings.C3P0_MIN_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_TIMEOUT;
import static org.hibernate.cfg.AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS;
import static org.hibernate.cfg.AvailableSettings.DRIVER;
import static org.hibernate.cfg.AvailableSettings.FORMAT_SQL;
import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;
import static org.hibernate.cfg.AvailableSettings.PASS;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;
import static org.hibernate.cfg.AvailableSettings.URL;
import static org.hibernate.cfg.AvailableSettings.USER;

import java.io.IOException;
import java.util.Properties;

import javax.jws.WebResult;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
public class HibernateConfigSecurity {

	@Autowired
	private Environment env; 
	
	@Bean
	@Qualifier("SecuritySessionFactoryBean")
	public LocalSessionFactoryBean getLocalSessionFactoryBean() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource( getDataSource() );
		localSessionFactoryBean.setHibernateProperties( getHibernateProperties() );
		localSessionFactoryBean.setPackagesToScan("com.tutorial.security.entities");

		try {
		    localSessionFactoryBean.afterPropertiesSet();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Security sessionFactory");
		
		return localSessionFactoryBean;
	}
	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(@Autowired @Qualifier("SecuritySessionFactoryBean")SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		
		return txManager;
	}
	
	
	public DataSource getDataSource() {
		DriverManagerDataSource  datasource = new DriverManagerDataSource ();
		datasource.setDriverClassName(env.getProperty("mysql.driver") );
		datasource.setUrl(env.getProperty("security.jdbcUrl"));
		datasource.setUsername(env.getProperty("mysql.username"));
		datasource.setPassword(env.getProperty("mysql.password"));
		return datasource;
	}
	
	public Properties getHibernateProperties() {
		Properties props = new Properties();
		  props.put(CURRENT_SESSION_CONTEXT_CLASS, "thread");
		  props.put(FORMAT_SQL,true);
		  props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
		  props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
		  props.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
		  props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
		  props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));
		  props.put(SHOW_SQL, true);
		return props;
	}
	
	
}
