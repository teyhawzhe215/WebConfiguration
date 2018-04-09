package com.user.daoImp;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.tutorial.entities.User;
import com.user.dao.UserDao;

@Repository("userDao")
public class UserDaoImp implements UserDao{

	@Autowired
	@Qualifier("userSessionFactory")
	SessionFactory sessionFactory;
	
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("From User");
		List<User> list = query.getResultList();
		session.close();
		return list;
	}
	
}
