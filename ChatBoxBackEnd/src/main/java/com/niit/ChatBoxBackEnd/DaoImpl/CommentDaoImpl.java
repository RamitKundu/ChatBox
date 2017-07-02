package com.niit.ChatBoxBackEnd.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ChatBoxBackEnd.Dao.CommentDao;
import com.niit.ChatBoxBackEnd.Model.Blog;
import com.niit.ChatBoxBackEnd.Model.Comments;


@Repository("commentDao")
@Transactional
public class CommentDaoImpl implements CommentDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	Blog blog;

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Comments> getAllComments() {
		
		return sessionFactory.getCurrentSession().createQuery("from Comments").list();
	}

	public boolean save(Comments comments) {
		try{
			 sessionFactory.getCurrentSession().save(comments);
			 return true;
		}
			catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
		
	}
	

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Comments> getByBlogId(int blogId) {
		return (List<Comments>) sessionFactory.getCurrentSession().createQuery("from Comments where blog.blogId='"+blogId+"'").list();
				

	}

}
