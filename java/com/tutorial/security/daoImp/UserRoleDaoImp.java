package com.tutorial.security.daoImp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.tutorial.security.dao.UserRoleDao;
import com.tutorial.security.entities.UserRole;

@Repository
public class UserRoleDaoImp implements UserRoleDao {

	@Autowired
	@Qualifier("SecuritySessionFactoryBean")
	private SessionFactory sessionFactory;
	
	@Override
	public List<UserRole> getUserRole(String email) {
		// TODO Auto-generated method stub
		
		Session session =  sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("From UserRole u where u.email = :email");
		query.setParameter("email", email);
		
		List<UserRole> userRole = null;
		
		if(query.getResultList().size()>0) {
			userRole= (List<UserRole>) query.getResultList();
		}
		
		session.close();
		
		return userRole;
	}

	@Override
	public void save(UserRole userRole) {
		// TODO Auto-generated method stub
		
		Session session =  sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		session.save(userRole);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public List<UserRole> getAllRole() {
		// TODO Auto-generated method stub
		Session session =  sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		List<UserRole> userRole = (List<UserRole>) session.createQuery("From UserRole u").getResultList();
		
		session.close();
		return userRole;
	}

}
