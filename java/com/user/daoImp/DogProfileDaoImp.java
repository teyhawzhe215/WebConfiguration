package com.user.daoImp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.tutorial.entities.DogProfile;
import com.user.dao.dogProfileDao;

@Repository
public class DogProfileDaoImp implements dogProfileDao {

	@Autowired
	@Qualifier("userSessionFactory")
	SessionFactory sessionFactory;
	
	@Override
	public List<DogProfile> getDogProfile() {
		// TODO Auto-generated method stub
		
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from DogProfile");
		
		List<DogProfile> list = query.getResultList();
		session.close();
		
		return list;
	}

}
