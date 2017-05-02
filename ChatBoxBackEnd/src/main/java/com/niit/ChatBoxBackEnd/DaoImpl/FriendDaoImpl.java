package com.niit.ChatBoxBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ChatBoxBackEnd.Dao.FriendDao;
import com.niit.ChatBoxBackEnd.Model.Friend;


@Repository
@Transactional
public class FriendDaoImpl implements FriendDao{
	
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<Friend> getAllFriend() {
		
		return sessionFactory.getCurrentSession().createQuery("from Friend").list();
	}

	public boolean addFriend(Friend friend) {
		
		try{
			 sessionFactory.getCurrentSession().save(friend);
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

	public boolean deleteFriend(Friend friend) {
		try{
			 sessionFactory.getCurrentSession().delete(friend);
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

	public boolean updateFriend(Friend friend) {
		
		try{
			 sessionFactory.getCurrentSession().update(friend);
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

	public Friend getById(int id) {
		
		return sessionFactory.getCurrentSession().get(Friend.class, id);
	}

}
