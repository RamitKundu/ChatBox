package com.niit.ChatBoxBackEnd.DaoImpl;

import java.util.List;

import javax.persistence.NoResultException;

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

	public User validate(String email, String password) {
		User user;
		try{
		Query query=sessionFactory.getCurrentSession().createQuery("from User where email=? and password=?");
		query.setString(0, email);
		query.setString(1, password);
		
		user=(User) query.uniqueResult();
		}
		catch(NoResultException e)
		{
			user=null;
		}
		return user;
			
	}
			
		
	

	public boolean delete(User user) {
		try{
			sessionFactory.getCurrentSession().delete(user);
			return true;
			}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

	public User getByEmail(String email) {
		
		User user;
		try
		{
			Query query= sessionFactory.getCurrentSession().createQuery("from User where email=?");
			query.setParameter(0, email);
			user=(User) query.uniqueResult();
			
		}
		catch(NoResultException e)
		{
			user=null;
		}
		return user;
			
	}

	public void setOnline(int userId) {
		sessionFactory.getCurrentSession().createQuery("update User set isOnline='OnLine' where userID='"+userId+"'").executeUpdate();
		
	}

	public void setOffline(int userId) {
		sessionFactory.getCurrentSession().createQuery("update User set isOnline='OffLine' where userID='"+userId+"'").executeUpdate();
		
	}

}
