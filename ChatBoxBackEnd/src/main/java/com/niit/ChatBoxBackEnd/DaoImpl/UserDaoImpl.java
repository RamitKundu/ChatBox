package com.niit.ChatBoxBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ChatBoxBackEnd.Dao.UserDao;
import com.niit.ChatBoxBackEnd.Model.User;



@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<User> getAllUser() {
		
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public User getById(int userId) {
		
		return (User) sessionFactory.getCurrentSession().get(User.class, userId);
	}

	public boolean add(User user) {
		try{
		sessionFactory.getCurrentSession().save(user);
		return true;
		}
		catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean update(User user) {
		try{
		sessionFactory.getCurrentSession().update(user);
		return true;
		}
		catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean validate(int userId, String password) {
		
		Query query=sessionFactory.getCurrentSession().createQuery("from User where userId=? and password=?");
		query.setInteger(0, userId);
		query.setString(1, password);
		
		if(query.uniqueResult()==null){
			return false;
		}
		else{
			return true;
		}
		
	}

}
