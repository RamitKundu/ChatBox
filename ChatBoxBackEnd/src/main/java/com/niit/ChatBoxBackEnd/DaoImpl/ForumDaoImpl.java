package com.niit.ChatBoxBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ChatBoxBackEnd.Dao.ForumDao;
import com.niit.ChatBoxBackEnd.Model.Forum;


@Transactional
@Repository
public class ForumDaoImpl implements ForumDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<Forum> getAllForum() {
		
		return sessionFactory.getCurrentSession().createQuery("from Forum").list();
	}

	public boolean addForum(Forum forum) {
		try{
			 sessionFactory.getCurrentSession().save(forum);
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

	public boolean updateForum(Forum forum) {
		try{
			 sessionFactory.getCurrentSession().update(forum);
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

	public boolean deleteForum(Forum forum) {
		try{
			 sessionFactory.getCurrentSession().delete(forum);
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
	}

	public Forum getById(int forumId) {
		
		return sessionFactory.getCurrentSession().get(Forum.class, forumId);
	}

}
