package com.niit.ChatBoxBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ChatBoxBackEnd.Dao.ForumCommentDao;
import com.niit.ChatBoxBackEnd.Model.ForumComment;

@Repository
@Transactional
public class ForumCommentDaoImpl implements ForumCommentDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<ForumComment> getAllForumCmmnt() {
		 return sessionFactory.getCurrentSession().createQuery("from ForumComment").list();
	}

	public boolean addForumCmmnt(ForumComment forumCmmnt) {
		try {
			sessionFactory.getCurrentSession().save(forumCmmnt);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

//	public ForumComment getByuserId(int userId) {
//		return sessionFactory.getCurrentSession().createQuery
//	}

}
