package com.tutorial.security.daoImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.tutorial.security.dao.UserandpassDao;
import com.tutorial.security.entities.Userandpass;

@Repository
public class UserandpassDaoImp implements UserandpassDao {

	@Autowired
	@Qualifier("SecuritySessionFactoryBean")
	private SessionFactory sessionFactory;
	
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Userandpass getUserandpass(String email) {
		// TODO Auto-generated method stub
		
		Session session =  sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Userandpass userandpass = null;
		
		Query query = session.createQuery("from Userandpass u where u.email = :email");
		query.setParameter("email", email);
		
		if(query.getResultList().size()>0) {
			userandpass = (Userandpass) query.getSingleResult();
		}
		session.close();
		
		return userandpass;
	}

	@Override
	public void save(Userandpass userandpass) {
		// TODO Auto-generated method stub
		Session session =  sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		userandpass.setPassword(passwordEncoder.encode( userandpass.getPassword()  ));
		
		session.save(userandpass);
		session.getTransaction().commit();
		session.close();
		
	}

}
