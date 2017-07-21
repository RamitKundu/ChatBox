package com.niit.ChatBoxBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ChatBoxBackEnd.Dao.ForumDao;
import com.niit.ChatBoxBackEnd.Model.Forum;


@Repository
@Transactional
public class ForumDaoImpl implements ForumDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public boolean addForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().save(forum);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Forum> getallForum() {
		return sessionFactory.getCurrentSession().createQuery("from Forum").list();
	}
	
	

}
