package com.tutorial.security.daoImp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.tutorial.security.dao.LoginDao;
import com.tutorial.security.entities.Login;

@Repository("token")
public class HibernateTokenRepositoryImpl implements PersistentTokenRepository {

	@Autowired
	private LoginDao loginDao;
	
	private String seriesTemp="";
	
	@Override
	public void createNewToken(PersistentRememberMeToken token) {
		// TODO Auto-generated method stub
		
		System.out.println("createNewToken");
		
		Login login = new Login();
		login.setEmail(token.getUsername());
		login.setLast_used(token.getDate().toString());
		login.setSeries(token.getSeries());
		login.setToken(token.getTokenValue());
		
		seriesTemp=token.getSeries();
		System.out.println("seriesTemp "+seriesTemp);
		
		loginDao.save(login);
	}

	@Override
	public void updateToken(String series, String tokenValue, Date lastUsed) {
		// TODO Auto-generated method stub
		
		System.out.println("updateToken");
		
		Login login = loginDao.getByKey(series);
		login.setLast_used(lastUsed.toString());
		login.setToken(tokenValue);
		loginDao.update(login);
	}

	@Override
	public PersistentRememberMeToken getTokenForSeries(String seriesId) {
		// TODO Auto-generated method stub
		
		System.out.println("getTokenForSeries");
		
		Login login = loginDao.getByKey(seriesId);
		
		if( login != null) {
			System.out.println("getTokenForSeries is not null");
			seriesTemp=login.getSeries();
			System.out.println("seriesTemp "+seriesTemp);
			return new PersistentRememberMeToken(login.getEmail(),login.getSeries(),login.getToken(),new Date(login.getLast_used()));
		}
		System.out.println("getTokenForSeries is null");
		
		return null;
	}

	@Override
	public void removeUserTokens(String username) {
		// TODO Auto-generated method stub

		System.out.println("removeUserTokens " +username);
		System.out.println("seriesTemp "+seriesTemp);
		loginDao.delete(seriesTemp);
		seriesTemp=null;
	}

}
