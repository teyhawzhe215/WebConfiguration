package com.tutorial.security.daoImp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.tutorial.security.dao.RoleDao;
import com.tutorial.security.entities.Role;

@Repository
public class RoleDaoImp implements RoleDao {

	@Autowired
	@Qualifier("SecuritySessionFactoryBean")
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		Session session =  sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		List<Role> list = session.createQuery("From Role").getResultList();
		
		session.close();
		
		return list;
	}

	@Override
	public Role findByName(String roleName) {
		// TODO Auto-generated method stub
		Session session =  sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("From Role r where r.roleName =:roleName");
		query.setParameter("roleName", roleName);
		
		Role role = null;
		
		if(query.getResultList().size()>0) {
			role = (Role) query.getSingleResult();
		}
		
		session.close();
		
		return role;
	}

}
