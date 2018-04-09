package com.tutorial.animalgroup.daoImp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.tutorial.animalgroup.dao.UserDao;
import com.tutorial.animalgroup.entities.User;

@Repository("AUser")
public class UserDaoImp implements UserDao {

	@Autowired
	@Qualifier(value="animalGroupSessionFactory")
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("From User");
		List<User> list = query.getResultList();
		session.close();
		return list;
	}

}
