package com.niit.ChatBoxBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ChatBoxBackEnd.Dao.UserProfileDao;
import com.niit.ChatBoxBackEnd.Model.UserProfile;

@Repository
@Transactional
public class UserProfiledaoImpl implements UserProfileDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean addUserProfile(UserProfile userProfile) {
		try {
			sessionFactory.getCurrentSession().save(userProfile);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<UserProfile> getallUProfile() {
		return sessionFactory.getCurrentSession().createQuery("from UserProfile").list();
	}

	public boolean updateUserProfile(UserProfile userProfile) {
		try {
			sessionFactory.getCurrentSession().update(userProfile);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

}
