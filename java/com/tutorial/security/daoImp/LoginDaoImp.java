package com.tutorial.security.daoImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.tutorial.security.dao.LoginDao;
import com.tutorial.security.entities.Login;

@Repository
public class LoginDaoImp implements LoginDao {

	@Autowired
	@Qualifier("SecuritySessionFactoryBean")
	private SessionFactory sessionFactory;
	
	
	@Override
	public void save(Login login) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		System.out.println("save login");
		session.save(login);
		session.getTransaction().commit();
		session.close();
	}


	@Override
	public Login getByKey(String key) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		System.out.println("getByKey login");
		Query query = session.createQuery("From Login l where l.series=:series");
		query.setParameter("series", key);
		
		Login login =null;
		
		if(query.getResultList().size()>0) {
			login = (Login) query.getSingleResult();
		}

		session.close();
		return login;
	}


	@Override
	public void update(Login login) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		System.out.println("update login");
		session.update(login);
		session.getTransaction().commit();
		session.close();
	}


	@Override
	public void delete(String login) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		System.out.println("delete login  " + login);
		Query query = session.createQuery("From Login l where l.email=:email");
		query.setParameter("email", login);
		
		Login logi = (Login) query.getSingleResult(); 
		
		session.delete(logi);
		
		session.getTransaction().commit();
		session.close();
	}

}
