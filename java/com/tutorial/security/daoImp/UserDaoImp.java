package com.tutorial.security.daoImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.tutorial.security.dao.UserDao;
import com.tutorial.security.entities.User;

@Repository("SUser")
public class UserDaoImp implements UserDao {

	@Autowired
	@Qualifier("SecuritySessionFactoryBean")
	private SessionFactory sessionFactory;
	
	
	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("From User u where u.email=:email");
		query.setParameter("email", email);
		User u =null;
		if(query.getResultList().size()>0) {
			u = (User) query.getSingleResult();
		}
		session.close();
		return u;
	}


	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

}
